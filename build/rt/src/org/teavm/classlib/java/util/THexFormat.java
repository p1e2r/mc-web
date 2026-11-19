package org.teavm.classlib.java.util;
/** mc-web: java.util.HexFormat (MIT License). */
public final class THexFormat {
    private static final THexFormat DEFAULT = new THexFormat("", "", "", false);
    private final String delimiter, prefix, suffix;
    private final boolean upper;
    private THexFormat(String delimiter, String prefix, String suffix, boolean upper) { this.delimiter = delimiter; this.prefix = prefix; this.suffix = suffix; this.upper = upper; }
    public static THexFormat of() { return DEFAULT; }
    public static THexFormat ofDelimiter(String d) { return new THexFormat(d, "", "", false); }
    public THexFormat withDelimiter(String d) { return new THexFormat(d, prefix, suffix, upper); }
    public THexFormat withPrefix(String p) { return new THexFormat(delimiter, p, suffix, upper); }
    public THexFormat withSuffix(String s) { return new THexFormat(delimiter, prefix, s, upper); }
    public THexFormat withUpperCase() { return new THexFormat(delimiter, prefix, suffix, true); }
    public THexFormat withLowerCase() { return new THexFormat(delimiter, prefix, suffix, false); }
    public String delimiter() { return delimiter; }
    public String prefix() { return prefix; }
    public String suffix() { return suffix; }
    public boolean isUpperCase() { return upper; }
    private char digit(int v) { char c = "0123456789abcdef".charAt(v & 15); return upper ? Character.toUpperCase(c) : c; }
    private String digits(long v, int n) { char[] c = new char[n]; for (int i = n - 1; i >= 0; i--) { c[i] = digit((int) v); v >>>= 4; } return new String(c); }
    public String toHexDigits(byte v) { return digits(v, 2); }
    public String toHexDigits(char v) { return digits(v, 4); }
    public String toHexDigits(short v) { return digits(v, 4); }
    public String toHexDigits(int v) { return digits(v, 8); }
    public String toHexDigits(long v) { return digits(v, 16); }
    public String toHexDigits(long v, int n) { return digits(v, n); }
    public String formatHex(byte[] b) { return formatHex(b, 0, b.length); }
    public String formatHex(byte[] b, int from, int to) {
        StringBuilder s = new StringBuilder();
        for (int i = from; i < to; i++) { if (i > from) s.append(delimiter); s.append(prefix).append(digits(b[i], 2)).append(suffix); }
        return s.toString();
    }
    public byte[] parseHex(CharSequence s) {
        String str = s.toString();
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        int i = 0;
        while (i < str.length()) {
            if (out.size() > 0) i += delimiter.length();
            i += prefix.length();
            out.write(Integer.parseInt(str.substring(i, i + 2), 16));
            i += 2 + suffix.length();
        }
        return out.toByteArray();
    }
    public static boolean isHexDigit(int c) { return Character.digit(c, 16) >= 0; }
    public static int fromHexDigit(int c) { int d = Character.digit(c, 16); if (d < 0) throw new NumberFormatException("not a hex digit: " + (char) c); return d; }
    public static int fromHexDigits(CharSequence s) { return fromHexDigits(s, 0, s.length()); }
    public static int fromHexDigits(CharSequence s, int from, int to) { return (int) fromHexDigitsToLong(s, from, to); }
    public static long fromHexDigitsToLong(CharSequence s) { return fromHexDigitsToLong(s, 0, s.length()); }
    public static long fromHexDigitsToLong(CharSequence s, int from, int to) {
        if (to - from > 16) throw new IllegalArgumentException("too many hex digits");
        long v = 0;
        for (int i = from; i < to; i++) v = (v << 4) | fromHexDigit(s.charAt(i));
        return v;
    }
}
