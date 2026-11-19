package org.teavm.classlib.java.lang;
/** mc-web (MIT License). */
public class TExceptionInInitializerError extends LinkageError {
    private Throwable exception;
    public TExceptionInInitializerError() { }
    public TExceptionInInitializerError(String s) { super(s); }
    public TExceptionInInitializerError(Throwable t) { super(null, t); exception = t; }
    public Throwable getException() { return exception; }
}
