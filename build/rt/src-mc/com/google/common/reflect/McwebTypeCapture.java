package com.google.common.reflect;

/**
 * mc-web (MIT License): TeaVM keeps no generic signatures, so TypeCapture.capture() cannot read the type argument of
 * an anonymous TypeToken subclass. The anonymous class itself is used as the captured type: each one is a unique,
 * stable identity, which is what DataFixerUpper's type witnesses (Mu.TYPE_TOKEN) rely on.
 */
public final class McwebTypeCapture {
    private McwebTypeCapture() { }
    public static java.lang.reflect.Type capture(TypeCapture<?> self) { return self.getClass(); }
}
