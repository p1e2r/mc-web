package mcweb.rt;
/** mc-web: Thread's ThreadLocalRandom fields; one green-thread world, so one copy is enough (MIT License). */
public final class ThreadFields {
    public static int threadLocalRandomProbe = 0x9E3779B9;
    public static long threadLocalRandomSeed;
    public static int threadLocalRandomSecondarySeed = 0x2545F491;
}
