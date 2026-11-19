package javax.sound.sampled;
/** mc-web: audio format description (no javax.sound playback in the browser). MIT License. */
public class AudioFormat {
    public static class Encoding {
        public static final Encoding PCM_SIGNED = new Encoding("PCM_SIGNED"), PCM_UNSIGNED = new Encoding("PCM_UNSIGNED"), PCM_FLOAT = new Encoding("PCM_FLOAT");
        private final String name;
        public Encoding(String name) { this.name = name; }
        @Override public String toString() { return name; }
    }
    protected Encoding encoding; protected float sampleRate; protected int sampleSizeInBits, channels, frameSize; protected float frameRate; protected boolean bigEndian;
    public AudioFormat(Encoding e, float sampleRate, int bits, int channels, int frameSize, float frameRate, boolean bigEndian) {
        this.encoding = e; this.sampleRate = sampleRate; this.sampleSizeInBits = bits; this.channels = channels; this.frameSize = frameSize; this.frameRate = frameRate; this.bigEndian = bigEndian;
    }
    public AudioFormat(float sampleRate, int bits, int channels, boolean signed, boolean bigEndian) {
        this(signed ? Encoding.PCM_SIGNED : Encoding.PCM_UNSIGNED, sampleRate, bits, channels, (bits + 7) / 8 * channels, sampleRate, bigEndian);
    }
    public Encoding getEncoding() { return encoding; }
    public float getSampleRate() { return sampleRate; }
    public int getSampleSizeInBits() { return sampleSizeInBits; }
    public int getChannels() { return channels; }
    public int getFrameSize() { return frameSize; }
    public float getFrameRate() { return frameRate; }
    public boolean isBigEndian() { return bigEndian; }
}
