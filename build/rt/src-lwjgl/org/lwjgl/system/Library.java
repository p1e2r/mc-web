package org.lwjgl.system;

import java.net.URL;
import java.nio.file.Path;
import java.util.function.Consumer;
import java.util.function.Supplier;

/** mc-web (TeaVM): there are no native libraries; every symbol is resolved by the JavaScript layer. MIT License. */
public final class Library {
    public static final String JNI_LIBRARY_NAME = "lwjgl";
    static final String JAVA_LIBRARY_PATH = "java.library.path";

    private Library() { }

    public static void initialize() { }
    public static void loadSystem(String module, String name) { }
    public static void loadSystem(Consumer<String> load, Consumer<String> loadLibrary, Class<?> context, String module, String name) { }
    public static SharedLibrary loadNative(String name) { return new WebSharedLibrary(name); }
    public static SharedLibrary loadNative(String module, String name) { return new WebSharedLibrary(name); }
    public static SharedLibrary loadNative(Class<?> context, String module, String name) { return new WebSharedLibrary(name); }
    public static SharedLibrary loadNative(Class<?> context, String module, String name, boolean bundledWithLWJGL) { return new WebSharedLibrary(name); }
    public static SharedLibrary loadNative(Class<?> context, String module, Configuration<String> name, String... defaultNames) { return new WebSharedLibrary(defaultNames.length > 0 ? defaultNames[0] : String.valueOf(name.get())); }
    public static SharedLibrary loadNative(Class<?> context, String module, Configuration<String> name, Supplier<SharedLibrary> fallback, String... defaultNames) {
        return loadNative(context, module, name, defaultNames);
    }
    static String mapLibraryName(String name) { return name; }
    public static String getVersionedName(String name) { return name; }
    static void checkHash(Class<?> context, Path libFile, String module, String libName) { }
    static URL findResource(Class<?> context, String module, String resource, boolean mapped) { return null; }
}
