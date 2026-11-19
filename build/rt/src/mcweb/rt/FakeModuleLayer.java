package mcweb.rt;
/** mc-web: stand-in for java.lang.ModuleLayer (MIT License). */
public final class FakeModuleLayer {
    public java.util.Optional<FakeModule> findModule(String name) { return java.util.Optional.empty(); }
}
