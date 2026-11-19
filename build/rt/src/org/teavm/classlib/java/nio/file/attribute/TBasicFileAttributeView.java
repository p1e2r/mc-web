package org.teavm.classlib.java.nio.file.attribute;
/** mc-web (MIT License). */
public interface TBasicFileAttributeView extends TFileAttributeView {
    java.nio.file.attribute.BasicFileAttributes readAttributes() throws java.io.IOException;
    void setTimes(java.nio.file.attribute.FileTime lastModified, java.nio.file.attribute.FileTime lastAccess, java.nio.file.attribute.FileTime create) throws java.io.IOException;
}
