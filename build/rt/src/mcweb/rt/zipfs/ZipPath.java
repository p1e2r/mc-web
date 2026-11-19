package mcweb.rt.zipfs;

import java.net.URI;
import java.nio.file.*;
import java.util.*;

/** mc-web: path inside a ZipFs; always stored normalized-ish with '/' separators (MIT License). */
public final class ZipPath implements Path {
    final ZipFs fs;
    final String path; // absolute paths start with '/'

    ZipPath(ZipFs fs, String path) { this.fs = fs; this.path = path; }

    private String[] parts() {
        String p = path.startsWith("/") ? path.substring(1) : path;
        if (p.isEmpty()) return new String[0];
        return p.split("/");
    }
    /** absolute, normalized path string used as the key into ZipData */
    String key() {
        String abs = path.startsWith("/") ? path : "/" + path;
        Deque<String> st = new ArrayDeque<>();
        for (String s : abs.substring(1).split("/")) {
            if (s.isEmpty() || s.equals(".")) continue;
            if (s.equals("..")) { if (!st.isEmpty()) st.removeLast(); } else st.addLast(s);
        }
        return "/" + String.join("/", st);
    }

    @Override public FileSystem getFileSystem() { return fs; }
    @Override public boolean isAbsolute() { return path.startsWith("/"); }
    @Override public Path getRoot() { return isAbsolute() ? new ZipPath(fs, "/") : null; }
    @Override public Path getFileName() {
        String[] p = parts();
        return p.length == 0 ? null : new ZipPath(fs, p[p.length - 1]);
    }
    @Override public Path getParent() {
        String[] p = parts();
        if (p.length == 0) return null;
        if (p.length == 1) return isAbsolute() ? new ZipPath(fs, "/") : null;
        return new ZipPath(fs, (isAbsolute() ? "/" : "") + String.join("/", Arrays.copyOf(p, p.length - 1)));
    }
    @Override public int getNameCount() { return parts().length; }
    @Override public Path getName(int i) { return new ZipPath(fs, parts()[i]); }
    @Override public Path subpath(int b, int e) { return new ZipPath(fs, String.join("/", Arrays.copyOfRange(parts(), b, e))); }
    @Override public boolean startsWith(Path other) {
        if (!(other instanceof ZipPath) || other.isAbsolute() != isAbsolute()) return false;
        String[] a = parts(), b = ((ZipPath) other).parts();
        if (b.length > a.length) return false;
        for (int i = 0; i < b.length; i++) if (!a[i].equals(b[i])) return false;
        return true;
    }
    @Override public boolean startsWith(String other) { return startsWith(fs.getPath(other)); }
    @Override public boolean endsWith(Path other) {
        if (!(other instanceof ZipPath)) return false;
        if (other.isAbsolute()) return equals(other);
        String[] a = parts(), b = ((ZipPath) other).parts();
        if (b.length > a.length) return false;
        for (int i = 0; i < b.length; i++) if (!a[a.length - b.length + i].equals(b[i])) return false;
        return true;
    }
    @Override public boolean endsWith(String other) { return endsWith(fs.getPath(other)); }
    @Override public Path normalize() { return isAbsolute() ? new ZipPath(fs, key()) : new ZipPath(fs, key().substring(1)); }
    @Override public Path resolve(Path other) {
        String o = other.toString();
        if (o.startsWith("/")) return new ZipPath(fs, o);
        if (o.isEmpty()) return this;
        if (path.isEmpty()) return new ZipPath(fs, o);
        return new ZipPath(fs, path.endsWith("/") ? path + o : path + "/" + o);
    }
    @Override public Path resolve(String other) { return resolve(new ZipPath(fs, other)); }
    @Override public Path resolveSibling(Path other) { Path p = getParent(); return p == null ? other : p.resolve(other); }
    @Override public Path resolveSibling(String other) { return resolveSibling(new ZipPath(fs, other)); }
    @Override public Path relativize(Path other) {
        String[] a = parts(), b = ((ZipPath) other).parts();
        int i = 0;
        while (i < a.length && i < b.length && a[i].equals(b[i])) i++;
        StringBuilder sb = new StringBuilder();
        for (int k = i; k < a.length; k++) sb.append(sb.length() > 0 ? "/" : "").append("..");
        for (int k = i; k < b.length; k++) sb.append(sb.length() > 0 ? "/" : "").append(b[k]);
        return new ZipPath(fs, sb.toString());
    }
    @Override public URI toUri() { return URI.create("jar:mcweb:" + fs.name + "!" + key()); }
    @Override public Path toAbsolutePath() { return isAbsolute() ? this : new ZipPath(fs, "/" + path); }
    @Override public Path toRealPath(LinkOption... o) { return normalize().toAbsolutePath(); }
    @Override public WatchKey register(WatchService w, WatchEvent.Kind<?>[] e, WatchEvent.Modifier... m) { throw new UnsupportedOperationException(); }
    @Override public Iterator<Path> iterator() {
        List<Path> l = new ArrayList<>();
        for (String s : parts()) l.add(new ZipPath(fs, s));
        return l.iterator();
    }
    @Override public int compareTo(Path o) { return path.compareTo(o.toString()); }
    @Override public boolean equals(Object o) { return o instanceof ZipPath && ((ZipPath) o).fs == fs && ((ZipPath) o).path.equals(path); }
    @Override public int hashCode() { return path.hashCode(); }
    @Override public String toString() { return path; }
}
