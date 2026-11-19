package org.teavm.classlib.java.lang.management;
/** mc-web (MIT License). */
public interface TGarbageCollectorMXBean {
    default String getName() { return "browser"; }
    default long getCollectionCount() { return 0; }
    default long getCollectionTime() { return 0; }
}
