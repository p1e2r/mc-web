package org.slf4j;

import org.slf4j.event.Level;
import org.slf4j.helpers.LegacyAbstractLogger;
import org.slf4j.helpers.MessageFormatter;

/** mc-web: slf4j without service lookup; logs to the browser console via System.out (MIT License). */
public final class LoggerFactory {
    private LoggerFactory() { }

    public static Logger getLogger(String name) { return new ConsoleLogger(name); }
    public static Logger getLogger(Class<?> c) { return new ConsoleLogger(c.getName()); }
    public static ILoggerFactory getILoggerFactory() { return LoggerFactory::getLogger; }

    @org.teavm.jso.JSBody(params = "s", script = "console.log(s);") static native void consoleLog(String s);
    @org.teavm.jso.JSBody(params = "s", script = "console.warn(s);") static native void consoleWarn(String s);
    @org.teavm.jso.JSBody(params = "s", script = "console.error(s);") static native void consoleError(String s);

    static final class ConsoleLogger extends LegacyAbstractLogger {
        ConsoleLogger(String name) { this.name = name; }
        public boolean isTraceEnabled() { return false; }
        public boolean isDebugEnabled() { return false; }
        public boolean isInfoEnabled() { return true; }
        public boolean isWarnEnabled() { return true; }
        public boolean isErrorEnabled() { return true; }
        protected String getFullyQualifiedCallerName() { return null; }
        protected void handleNormalizedLoggingCall(Level level, Marker marker, String msg, Object[] args, Throwable t) {
            String text = MessageFormatter.basicArrayFormat(msg, args);
            String n = name.substring(name.lastIndexOf('.') + 1);
            String line = "[" + level + "] " + n + ": " + text;
            if (t != null) {
                java.io.StringWriter sw = new java.io.StringWriter();
                t.printStackTrace(new java.io.PrintWriter(sw));
                line += "\n" + sw;
                // TeaVM prints the cause field only; some exceptions (ReportedException) override getCause()
                Throwable c = t.getCause();
                for (int i = 0; c != null && i < 8 && line.indexOf(String.valueOf(c)) < 0; i++, c = c.getCause()) {
                    java.io.StringWriter cw = new java.io.StringWriter();
                    c.printStackTrace(new java.io.PrintWriter(cw));
                    line += "Caused by (getCause): " + cw;
                }
            }
            if (level == Level.ERROR) consoleError(line);
            else if (level == Level.WARN) consoleWarn(line);
            else consoleLog(line);
        }
    }
}
