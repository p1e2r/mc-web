package com.ibm.icu.util;
/** mc-web: minimal ICU stand-in (MIT License). */
public class TimeZone {
    public static final TimeZone UNKNOWN_ZONE = new TimeZone("Etc/Unknown");
    final String id;
    TimeZone(String id) { this.id = id; }
    public static TimeZone getTimeZone(String id) { return new TimeZone(id); }
    public String getID() { return id; }
    @Override public boolean equals(Object o) { return o instanceof TimeZone && ((TimeZone) o).id.equals(id); }
    @Override public int hashCode() { return id.hashCode(); }
}
