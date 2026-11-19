package mcweb.rt;
/** mc-web: stand-in for java.lang.Module (MIT License). */
public final class FakeModule {
    public FakeModuleLayer getLayer() { return new FakeModuleLayer(); }
    public String getName() { return null; }
    public boolean isNamed() { return false; }
}
