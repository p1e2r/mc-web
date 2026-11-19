package org.lwjgl.system;

import org.lwjgl.web.WebFFI;

import java.nio.ByteBuffer;

/** A "shared library" whose symbols are resolved by the JavaScript layer. */
public final class WebSharedLibrary extends SharedLibrary.Default {
    private static long nextHandle = 0x50000000L;

    private static synchronized long handle() {
        long h = nextHandle;
        nextHandle += 16;
        return h;
    }

    public WebSharedLibrary(String name) {
        super(name, handle());
    }

    @Override
    public String getPath() {
        return "web:" + getName();
    }

    @Override
    public long getFunctionAddress(ByteBuffer functionName) {
        StringBuilder sb = new StringBuilder();
        for (int i = functionName.position(); i < functionName.limit(); i++) {
            byte b = functionName.get(i);
            if (b == 0) {
                break;
            }
            sb.append((char)(b & 0xFF));
        }
        return getFunctionAddress(sb);
    }

    @Override
    public long getFunctionAddress(CharSequence functionName) {
        return WebFFI.symbol(functionName.toString());
    }

    @Override
    public void free() {}
}
