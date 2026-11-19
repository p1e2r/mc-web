package org.teavm.classlib.java.nio.file.attribute;
/** mc-web (MIT License). */
public interface TDosFileAttributeView extends TBasicFileAttributeView {
    void setReadOnly(boolean v) throws java.io.IOException;
    void setHidden(boolean v) throws java.io.IOException;
    void setSystem(boolean v) throws java.io.IOException;
    void setArchive(boolean v) throws java.io.IOException;
}
