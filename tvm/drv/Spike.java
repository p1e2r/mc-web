import org.teavm.tooling.*;
import org.teavm.diagnostics.*;
import org.teavm.model.CallLocation;
import org.teavm.vm.TeaVMOptimizationLevel;
import java.io.*;
import java.net.*;
import java.nio.file.*;
import java.util.*;

public class Spike {
    public static void main(String[] a) throws Exception {
        String mcdir = a[0], outDir = a[1], main = a[2];
        List<URL> urls = new ArrayList<>();
        for (String line : Files.readAllLines(Paths.get(a[3]))) if (!line.isBlank()) urls.add(new File(mcdir, line.trim()).toURI().toURL());
        TeaVMTool tool = new TeaVMTool();
        tool.setTargetType(TeaVMTargetType.valueOf(a.length > 4 ? a[4] : "JAVASCRIPT"));
        tool.setMainClass(main);
        tool.setTargetDirectory(new File(outDir));
        tool.setTargetFileName("classes.js");
        tool.setObfuscated(false);
        tool.setOptimizationLevel(TeaVMOptimizationLevel.valueOf(System.getProperty("tvm.opt", "SIMPLE")));
        tool.setFastDependencyAnalysis(Boolean.getBoolean("tvm.fast"));
        // Program classes: overlay + game jars + TeaVM runtime jars. JDK classes (jrt) are NOT visible unless listed
        // explicitly, so every JDK class TeaVM's classlib lacks shows up as a missing class instead of being compiled
        // from desktop-JDK bytecode.
        for (File f : new File(System.getProperty("tvm.lib", "lib")).listFiles()) if (f.getName().startsWith("teavm-")) urls.add(f.toURI().toURL());
        tool.setClassLoader(new URLClassLoader(urls.toArray(new URL[0]), Spike.class.getClassLoader()) {
            boolean jdk(String n) { return n.startsWith("java/") || n.startsWith("javax/") || n.startsWith("jdk/") || n.startsWith("sun/") || n.startsWith("com/sun/"); }
            @Override public URL getResource(String n) { return jdk(n) ? findResource(n) : super.getResource(n); }
            @Override public InputStream getResourceAsStream(String n) {
                if (!jdk(n)) return super.getResourceAsStream(n);
                URL u = findResource(n);
                try { return u == null ? null : u.openStream(); } catch (IOException e) { return null; }
            }
            @Override public Enumeration<URL> getResources(String n) throws IOException { return jdk(n) ? findResources(n) : super.getResources(n); }
            @Override protected Class<?> loadClass(String n, boolean r) throws ClassNotFoundException { return super.loadClass(n, r); }
        });
        tool.setLog(new TeaVMToolLog() {
            public void info(String t) { System.out.println("I " + t); }
            public void debug(String t) {}
            public void warning(String t) { System.out.println("W " + t); }
            public void error(String t) { System.out.println("E " + t); }
            public void info(String t, Throwable e) { info(t); }
            public void debug(String t, Throwable e) {}
            public void warning(String t, Throwable e) { warning(t); }
            public void error(String t, Throwable e) { error(t); e.printStackTrace(System.out); }
        });
        long t0 = System.currentTimeMillis();
        try { tool.generate(); } catch (Throwable e) { e.printStackTrace(System.out); }
        ProblemProvider pp = tool.getProblemProvider();
        System.out.println("PROBLEMS total=" + pp.getProblems().size() + " severe=" + pp.getSevereProblems().size() + " in " + (System.currentTimeMillis() - t0) + " ms");
        DefaultProblemTextConsumer c = new DefaultProblemTextConsumer();
        try (PrintWriter w = new PrintWriter(new FileWriter(outDir + "/problems.txt"))) {
            for (Problem p : pp.getProblems()) {
                c.clear(); p.render(c);
                w.println(p.getSeverity() + "\t" + c.getText());
                CallLocation loc = p.getLocation();
                if (loc != null && loc.getMethod() != null) w.println("\t@ " + loc.getMethod());
            }
        }
    }
}
