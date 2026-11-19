package mcweb.rt.zipfs;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.nio.file.spi.FileSystemProvider;
import java.util.*;

/** mc-web: read-only file system over an in-memory zip (MIT License). */
public final class ZipFs extends FileSystem {
    final ZipFsProvider provider;
    final ZipData zip;
    final String name;
    boolean open = true;

    ZipFs(ZipFsProvider provider, ZipData zip, String name) { this.provider = provider; this.zip = zip; this.name = name; }

    public ZipData data() { return zip; }
    @Override public FileSystemProvider provider() { return provider; }
    @Override public void close() { open = false; }
    @Override public boolean isOpen() { return open; }
    @Override public boolean isReadOnly() { return true; }
    @Override public String getSeparator() { return "/"; }
    @Override public Iterable<Path> getRootDirectories() { return Collections.singletonList(new ZipPath(this, "/")); }
    @Override public Iterable<FileStore> getFileStores() { return Collections.emptyList(); }
    @Override public Set<String> supportedFileAttributeViews() { return Collections.singleton("basic"); }
    @Override public Path getPath(String first, String... more) {
        StringBuilder sb = new StringBuilder(first);
        for (String m : more) { if (m.isEmpty()) continue; if (sb.length() > 0 && sb.charAt(sb.length() - 1) != '/') sb.append('/'); sb.append(m); }
        String s = sb.toString();
        while (s.length() > 1 && s.endsWith("/")) s = s.substring(0, s.length() - 1);
        return new ZipPath(this, s);
    }
    @Override public PathMatcher getPathMatcher(String syntaxAndPattern) { return mcweb.rt.Shim.fsGetPathMatcher(this, syntaxAndPattern); }
    @Override public UserPrincipalLookupService getUserPrincipalLookupService() { throw new UnsupportedOperationException(); }
    @Override public WatchService newWatchService() throws IOException { throw new UnsupportedOperationException(); }
}
