package com.ibm.icu.util;
/** mc-web: minimal ICU stand-in (MIT License). */
public class Calendar {
    final TimeZone zone;
    Calendar(TimeZone zone) { this.zone = zone; }
    public static Calendar getInstance(TimeZone zone, ULocale locale) { return new Calendar(zone); }
    public static Calendar getInstance(ULocale locale) { return new Calendar(null); }
}
