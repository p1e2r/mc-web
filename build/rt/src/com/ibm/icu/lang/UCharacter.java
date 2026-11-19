package com.ibm.icu.lang;
/** mc-web: minimal ICU stand-in (MIT License). */
public final class UCharacter {
    public static int getMirror(int ch) {
        switch (ch) {
            case '(': return ')'; case ')': return '(';
            case '[': return ']'; case ']': return '[';
            case '{': return '}'; case '}': return '{';
            case '<': return '>'; case '>': return '<';
            default: return ch;
        }
    }
}
