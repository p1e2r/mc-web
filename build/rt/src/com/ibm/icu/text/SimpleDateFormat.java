package com.ibm.icu.text;
/** mc-web: minimal ICU stand-in backed by java.text.SimpleDateFormat (MIT License). */
public class SimpleDateFormat extends DateFormat {
    final String pattern;
    public SimpleDateFormat(String pattern, com.ibm.icu.util.ULocale locale) { this.pattern = pattern; }
    public void setCalendar(com.ibm.icu.util.Calendar c) { }
    @Override public String format(java.util.Date d) {
        try { return new java.text.SimpleDateFormat(pattern).format(d); } catch (RuntimeException e) { return d.toString(); }
    }
}
