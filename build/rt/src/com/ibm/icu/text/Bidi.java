package com.ibm.icu.text;
/** mc-web: minimal ICU stand-in. Text is left in logical order (no right-to-left reordering). MIT License. */
public class Bidi {
    final String text;
    public Bidi(String text, int paraLevel) { this.text = text; }
    public void setReorderingMode(int mode) { }
    public int countRuns() { return 1; }
    public BidiRun getVisualRun(int i) { return new BidiRun(0, text.length()); }
    public String writeReordered(int options) { return text; }
}
