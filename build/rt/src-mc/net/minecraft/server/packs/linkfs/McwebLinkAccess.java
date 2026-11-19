package net.minecraft.server.packs.linkfs;

import java.nio.file.Path;

/** mc-web: unwraps Minecraft's link file system paths (package-private classes) to the real file (MIT License). */
public final class McwebLinkAccess {
    private McwebLinkAccess() { }

    /** The real file behind a link path, or null if {@code p} is not a link path. */
    public static Path target(Path p) {
        return p instanceof LinkFSPath ? ((LinkFSPath) p).getTargetPath() : null;
    }
}
