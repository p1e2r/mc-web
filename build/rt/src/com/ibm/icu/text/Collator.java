package com.ibm.icu.text;
/** mc-web: minimal ICU stand-in: plain case-insensitive string order (MIT License). */
public class Collator implements java.util.Comparator<Object> {
    public static Collator getInstance(java.util.Locale l) { return new Collator(); }
    public int compare(String a, String b) { int c = a.compareToIgnoreCase(b); return c != 0 ? c : a.compareTo(b); }
    @Override public int compare(Object a, Object b) { return compare(String.valueOf(a), String.valueOf(b)); }
}
