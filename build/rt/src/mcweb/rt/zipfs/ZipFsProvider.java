package mcweb.rt.zipfs;

import java.io.*;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.channels.NonWritableChannelException;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.nio.file.spi.FileSystemProvider;
import java.util.*;

/** mc-web: "jar" file system provider over in-memory zips (MIT License). */
public final class ZipFsProvider extends FileSystemProvider {
    static ZipFsProvider instance;
    final Map<String, ZipFs> byName = new HashMap<>();

    public ZipFsProvider() { instance = this; }

    public static ZipFsProvider get() { return instance != null ? instance : new ZipFsProvider(); }

    /** Mount zip bytes under a name; paths are then reachable as jar:mcweb:<name>!/... */
    public ZipFs mount(String name, byte[] data) throws IOException {
        ZipFs fs = new ZipFs(this, new ZipData(data), name);
        byName.put(name, fs);
        return fs;
    }

    @Override public String getScheme() { return "jar"; }

    private static String nameOf(URI uri) {
        String s = uri.getSchemeSpecificPart();
        int bang = s.indexOf('!');
        return bang >= 0 ? s.substring(0, bang) : s;
    }

    @Override public FileSystem newFileSystem(URI uri, Map<String, ?> env) throws IOException {
        String n = nameOf(uri);
        if (n.startsWith("mcweb:")) {
            ZipFs fs = byName.get(n.substring(6));
            if (fs == null) throw new FileSystemNotFoundException(n);
            return fs;
        }
        if (n.startsWith("file:")) n = n.substring(5);
        return newFileSystem(Paths.get(n), env);
    }
    @Override public FileSystem newFileSystem(Path path, Map<String, ?> env) throws IOException {
        return mount(path.toString(), Files.readAllBytes(path));
    }
    @Override public FileSystem getFileSystem(URI uri) {
        String n = nameOf(uri);
        ZipFs fs = byName.get(n.startsWith("mcweb:") ? n.substring(6) : n);
        if (fs == null) throw new FileSystemNotFoundException(n);
        return fs;
    }
    @Override public Path getPath(URI uri) {
        String s = uri.getSchemeSpecificPart();
        int bang = s.indexOf('!');
        return getFileSystem(uri).getPath(bang >= 0 ? s.substring(bang + 1) : "/");
    }

    private static ZipPath zp(Path p) {
        if (!(p instanceof ZipPath)) throw new ProviderMismatchException();
        return (ZipPath) p;
    }

    @Override public InputStream newInputStream(Path path, OpenOption... options) throws IOException {
        ZipPath p = zp(path);
        return p.fs.zip.open(p.key());
    }
    @Override public SeekableByteChannel newByteChannel(Path path, Set<? extends OpenOption> options, FileAttribute<?>... attrs) throws IOException {
        for (OpenOption o : options) if (o == StandardOpenOption.WRITE || o == StandardOpenOption.APPEND) throw new ReadOnlyFileSystemException();
        ZipPath p = zp(path);
        byte[] b = p.fs.zip.read(p.key());
        return new SeekableByteChannel() {
            long pos; boolean open = true;
            public int read(ByteBuffer dst) { if (pos >= b.length) return -1; int n = (int) Math.min(dst.remaining(), b.length - pos); dst.put(b, (int) pos, n); pos += n; return n; }
            public int write(ByteBuffer src) { throw new NonWritableChannelException(); }
            public long position() { return pos; }
            public SeekableByteChannel position(long p2) { pos = p2; return this; }
            public long size() { return b.length; }
            public SeekableByteChannel truncate(long s) { throw new NonWritableChannelException(); }
            public boolean isOpen() { return open; }
            public void close() { open = false; }
        };
    }
    @Override public DirectoryStream<Path> newDirectoryStream(Path dir, DirectoryStream.Filter<? super Path> filter) throws IOException {
        ZipPath p = zp(dir);
        String k = p.key();
        if (!p.fs.zip.isDir(k)) throw new NotDirectoryException(dir.toString());
        List<Path> out = new ArrayList<>();
        for (String child : p.fs.zip.list(k)) {
            Path c = p.resolve(child);
            if (filter == null || filter.accept(c)) out.add(c);
        }
        return new DirectoryStream<Path>() {
            public Iterator<Path> iterator() { return out.iterator(); }
            public void close() { }
        };
    }
    @Override public void createDirectory(Path dir, FileAttribute<?>... attrs) { throw new ReadOnlyFileSystemException(); }
    @Override public void delete(Path path) { throw new ReadOnlyFileSystemException(); }
    @Override public void copy(Path s, Path t, CopyOption... o) { throw new ReadOnlyFileSystemException(); }
    @Override public void move(Path s, Path t, CopyOption... o) { throw new ReadOnlyFileSystemException(); }
    @Override public boolean isSameFile(Path a, Path b) { return a.equals(b) || zp(a).key().equals(zp(b).key()); }
    @Override public boolean isHidden(Path path) { return false; }
    @Override public FileStore getFileStore(Path path) { throw new UnsupportedOperationException(); }
    @Override public void checkAccess(Path path, AccessMode... modes) throws IOException {
        ZipPath p = zp(path);
        String k = p.key();
        if (!p.fs.zip.isFile(k) && !p.fs.zip.isDir(k)) throw new NoSuchFileException(path.toString());
        for (AccessMode m : modes) if (m == AccessMode.WRITE) throw new AccessDeniedException(path.toString());
    }
    @Override public <V extends FileAttributeView> V getFileAttributeView(Path path, Class<V> type, LinkOption... options) { return null; }

    @SuppressWarnings("unchecked")
    @Override public <A extends BasicFileAttributes> A readAttributes(Path path, Class<A> type, LinkOption... options) throws IOException {
        ZipPath p = zp(path);
        String k = p.key();
        boolean file = p.fs.zip.isFile(k), dir = p.fs.zip.isDir(k);
        if (!file && !dir) throw new NoSuchFileException(path.toString());
        FileTime t = FileTime.fromMillis(file ? p.fs.zip.time(k) : 0);
        long size = file ? p.fs.zip.size(k) : 0;
        return (A) new BasicFileAttributes() {
            public FileTime lastModifiedTime() { return t; }
            public FileTime lastAccessTime() { return t; }
            public FileTime creationTime() { return t; }
            public boolean isRegularFile() { return file; }
            public boolean isDirectory() { return dir; }
            public boolean isSymbolicLink() { return false; }
            public boolean isOther() { return false; }
            public long size() { return size; }
            public Object fileKey() { return k; }
        };
    }
    @Override public Map<String, Object> readAttributes(Path path, String attributes, LinkOption... options) throws IOException {
        BasicFileAttributes a = readAttributes(path, BasicFileAttributes.class, options);
        Map<String, Object> m = new HashMap<>();
        m.put("size", a.size()); m.put("isDirectory", a.isDirectory()); m.put("isRegularFile", a.isRegularFile());
        m.put("lastModifiedTime", a.lastModifiedTime());
        return m;
    }
    @Override public void setAttribute(Path path, String attribute, Object value, LinkOption... options) { throw new ReadOnlyFileSystemException(); }
}
