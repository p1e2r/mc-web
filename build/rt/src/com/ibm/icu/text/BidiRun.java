package com.ibm.icu.text;
/** mc-web: minimal ICU stand-in (MIT License). */
public class BidiRun {
    final int start, length;
    BidiRun(int start, int length) { this.start = start; this.length = length; }
    public int getStart() { return start; }
    public int getLength() { return length; }
    public boolean isOddRun() { return false; }
}
