package org.slf4j;

import org.slf4j.helpers.BasicMarkerFactory;

/** mc-web: MarkerFactory without provider lookup (MIT License). */
public class MarkerFactory {
    private static final IMarkerFactory FACTORY = new BasicMarkerFactory();
    public static Marker getMarker(String name) { return FACTORY.getMarker(name); }
    public static Marker getDetachedMarker(String name) { return FACTORY.getDetachedMarker(name); }
    public static IMarkerFactory getIMarkerFactory() { return FACTORY; }
}
