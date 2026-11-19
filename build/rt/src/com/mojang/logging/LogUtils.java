package com.mojang.logging;

import java.util.function.Supplier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

/** mc-web: Mojang's LogUtils without log4j-core or StackWalker (MIT License). */
public class LogUtils {
    public static final String FATAL_MARKER_ID = "FATAL";
    public static final Marker FATAL_MARKER = MarkerFactory.getMarker(FATAL_MARKER_ID);

    public static boolean isLoggerActive() { return true; }
    public static void configureRootLoggingLevel(org.slf4j.event.Level level) { }
    public static Object defer(Supplier<Object> s) {
        return new Object() { @Override public String toString() { return String.valueOf(s.get()); } };
    }
    public static Logger getLogger() { return LoggerFactory.getLogger("Minecraft"); }
}
