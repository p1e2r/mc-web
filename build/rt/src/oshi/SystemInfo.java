package oshi;
/** mc-web: OSHI hardware info is not available in the browser. */
public class SystemInfo {
    public oshi.hardware.HardwareAbstractionLayer getHardware() { throw new UnsupportedOperationException("OSHI is not available in the browser"); }
    public oshi.software.os.OperatingSystem getOperatingSystem() { throw new UnsupportedOperationException("OSHI is not available in the browser"); }
}
