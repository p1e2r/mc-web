package jdk.jfr;
/** mc-web: JFR events are never enabled in the browser (MIT License). */
public abstract class Event {
    protected Event() { }
    public final void begin() { }
    public final void end() { }
    public final void commit() { }
    public final boolean isEnabled() { return false; }
    public final boolean shouldCommit() { return false; }
    public final void set(int index, Object value) { }
}
