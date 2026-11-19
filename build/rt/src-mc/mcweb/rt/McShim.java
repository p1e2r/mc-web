package mcweb.rt;
/** mc-web: Minecraft/library-specific redirect targets (MIT License). */
public final class McShim {
    private McShim() { }
    /** JvmProfiler picks JFR only if available; never in the browser. */
    public static net.minecraft.util.profiling.jfr.JfrProfiler noJfr() { throw new UnsupportedOperationException("JFR"); }
    /** Gson falls back to this when a class has no no-arg constructor. */
    public static com.google.gson.internal.UnsafeAllocator gsonAllocator() {
        return new com.google.gson.internal.UnsafeAllocator() {
            @Override public <T> T newInstance(Class<T> c) { throw new UnsupportedOperationException("Cannot allocate " + c.getName() + " without a constructor"); }
        };
    }

    /** Netty logs through slf4j (our console logger) instead of probing log4j. */
    public static io.netty.util.internal.logging.InternalLoggerFactory nettyLoggerFactory(String name) {
        return io.netty.util.internal.logging.Slf4JLoggerFactory.INSTANCE;
    }
    /** No speech synthesis in the browser. */
    public static com.mojang.text2speech.Narrator dummyNarrator() { return com.mojang.text2speech.Narrator.EMPTY; }

    /** jopt-simple's converter lookup without reflection: the option types Minecraft's Main uses. */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static <V> joptsimple.ValueConverter<V> joptConverter(Class<V> c) {
        java.util.function.Function<String, Object> f;
        if (c == java.io.File.class) f = java.io.File::new;
        else if (c == Integer.class) f = Integer::valueOf;
        else if (c == Long.class) f = Long::valueOf;
        else if (c == Double.class) f = Double::valueOf;
        else if (c == Float.class) f = Float::valueOf;
        else if (c == Boolean.class) f = Boolean::valueOf;
        else if (c == String.class) f = s -> s;
        else if (c.isEnum()) f = s -> {
            for (Object e : c.getEnumConstants()) if (((Enum<?>) e).name().equalsIgnoreCase(s)) return e;
            throw new IllegalArgumentException("No enum constant " + c.getName() + "." + s);
        };
        else throw new IllegalArgumentException("No converter for " + c.getName());
        final java.util.function.Function<String, Object> fn = f;
        return new joptsimple.ValueConverter<V>() {
            public V convert(String s) { return (V) fn.apply(s); }
            public Class<? extends V> valueType() { return c; }
            public String valuePattern() { return null; }
        };
    }

    /** VanillaPackResourcesBuilder.ROOT_DIR_BY_TYPE: the asset/data roots inside the mounted client.jar. */
    public static com.google.common.collect.ImmutableMap<net.minecraft.server.packs.PackType, java.nio.file.Path> vanillaRoots() {
        com.google.common.collect.ImmutableMap.Builder<net.minecraft.server.packs.PackType, java.nio.file.Path> b = com.google.common.collect.ImmutableMap.builder();
        for (net.minecraft.server.packs.PackType t : net.minecraft.server.packs.PackType.values())
            b.put(t, Boot.vanilla.getPath("/" + t.getDirectory()));
        return b.build();
    }

    /** Class.getResourceAsStream: resources live in the mounted client.jar */
    public static java.io.InputStream classGetResourceAsStream(Class<?> c, String name) {
        String key;
        if (name.startsWith("/")) key = name;
        else {
            String cn = c.getName();
            int dot = cn.lastIndexOf('.');
            key = "/" + (dot < 0 ? "" : cn.substring(0, dot).replace('.', '/') + "/") + name;
        }
        return openResource(key);
    }
    public static java.io.InputStream classLoaderGetResourceAsStream(ClassLoader l, String name) { return openResource("/" + name); }
    public static java.io.InputStream classLoaderGetSystemResourceAsStream(String name) { return openResource("/" + name); }
    static java.io.InputStream openResource(String key) {
        if (Boot.vanilla == null || !Boot.vanilla.data().isFile(key)) return null;
        try { return Boot.vanilla.data().open(key); } catch (java.io.IOException e) { return null; }
    }

    /** DataFixers.optimize precomputes rewrite rules for upgrading old worlds: skipped (slow, not needed for new worlds). */
    public static java.util.concurrent.CompletableFuture<?> dfuOptimize(java.util.Set<com.mojang.datafixers.DSL.TypeReference> types) {
        return java.util.concurrent.CompletableFuture.completedFuture(null);
    }

    /** netty's ReflectiveChannelFactory needs Class.getConstructor(); singleplayer only uses the in-memory channels. */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static io.netty.bootstrap.AbstractBootstrap bootstrapChannel(io.netty.bootstrap.AbstractBootstrap b, Class c) {
        io.netty.channel.ChannelFactory f;
        if (c == io.netty.channel.local.LocalServerChannel.class) f = io.netty.channel.local.LocalServerChannel::new;
        else if (c == io.netty.channel.local.LocalChannel.class) f = io.netty.channel.local.LocalChannel::new;
        else throw new UnsupportedOperationException("mc-web: no channel factory for " + c);
        return b.channelFactory(f);
    }

    private static final java.util.HashSet<String> badParticles = new java.util.HashSet<>();

    /** a particle that throws while ticking is removed (and its type logged once) instead of crashing the client. */
    public static void tickParticle(net.minecraft.client.particle.ParticleGroup g, net.minecraft.client.particle.Particle p) {
        if (p == null) return;
        try {
            p.tick();
        } catch (Throwable t) {
            String n = p.getClass().getName();
            if (badParticles.add(n)) {
                System.err.println("[mc-web] particle " + n + " failed to tick; removing it");
                t.printStackTrace();
            }
            p.remove();
        }
    }

    /**
     * Asset-index objects (sounds, icons, unifont) are not bundled: fetch them from the page's mc/assets/objects on
     * first use. They are not kept in the in-memory file system; the browser's HTTP cache keeps repeat loads cheap.
     */
    public static java.nio.channels.SeekableByteChannel assetByteChannel(java.nio.file.Path p,
            java.util.Set<? extends java.nio.file.OpenOption> opts, java.nio.file.attribute.FileAttribute<?>... attrs) throws java.io.IOException {
        String s = p.toString().replace('\\', '/');
        if (s.startsWith("/mc/assets/objects/") && !java.nio.file.Files.exists(p)) {
            byte[] b = Boot.fetchOrNull(s.substring(1));
            if (b == null) throw new java.nio.file.NoSuchFileException(s);
            return new ByteArrayChannel(b);
        }
        return Shim.filesNewByteChannel(p, opts, attrs);
    }

    /** TeaVM's FileSystemProvider has no newByteChannel fallback for newInputStream: read link-FS files directly. */
    public static java.io.InputStream filesNewInputStream(java.nio.file.Path p, java.nio.file.OpenOption... opts) throws java.io.IOException {
        java.nio.file.Path t = net.minecraft.server.packs.linkfs.McwebLinkAccess.target(p);
        if (t == null) return java.nio.file.Files.newInputStream(p, opts);
        String s = t.toString().replace('\\', '/');
        if (s.startsWith("/mc/assets/objects/") && !java.nio.file.Files.exists(t)) {
            byte[] b = Boot.fetchOrNull(s.substring(1));
            if (b == null) throw new java.nio.file.NoSuchFileException(s);
            return new java.io.ByteArrayInputStream(b);
        }
        return java.nio.file.Files.newInputStream(t, opts);
    }
}
