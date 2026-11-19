package org.teavm.classlib.java.util;
/** mc-web: java.util.StringJoiner (MIT License). */
public final class TStringJoiner {
    private final String prefix, delimiter, suffix;
    private StringBuilder value;
    private String emptyValue;
    public TStringJoiner(CharSequence delimiter) { this(delimiter, "", ""); }
    public TStringJoiner(CharSequence delimiter, CharSequence prefix, CharSequence suffix) {
        this.delimiter = delimiter.toString(); this.prefix = prefix.toString(); this.suffix = suffix.toString(); this.emptyValue = this.prefix + this.suffix;
    }
    public TStringJoiner setEmptyValue(CharSequence e) { emptyValue = e.toString(); return this; }
    public TStringJoiner add(CharSequence s) {
        if (value == null) value = new StringBuilder(prefix); else value.append(delimiter);
        value.append(s);
        return this;
    }
    public TStringJoiner merge(TStringJoiner o) {
        if (o.value != null) add(o.value.substring(o.prefix.length()));
        return this;
    }
    public int length() { return value == null ? emptyValue.length() : value.length() + suffix.length(); }
    @Override public String toString() { return value == null ? emptyValue : value + suffix; }
}
