package mcweb.rt;

import mcweb.rt.ArrayDeque2;
import java.util.Iterator;

/** mc-web: small TeaVM test entry point for runtime behaviour checks (MIT License). */
public final class Probe {
    public static void main(String[] args) throws Exception {
        for (int start : new int[]{0, 5, 14}) {
            ArrayDeque2<Integer> d = new ArrayDeque2<>(16);
            for (int i = 0; i < start; i++) { d.add(-1); d.poll(); }
            if (start == 14) for (int i = 0; i < 20; i++) d.addFirst(100 + i);
            if (start == 14) d.removeIf(x -> x >= 100);   // move head to exercise wrap-around
            for (int i = 0; i < 10; i++) d.add(i);
            for (Iterator<Integer> it = d.iterator(); it.hasNext(); ) { Integer v = it.next(); if (v == null) System.out.println(" null seen!"); else if (v % 2 == 0 || v == 7) it.remove(); }
            StringBuilder b = new StringBuilder();
            for (Integer v : d) b.append(v).append(' ');
            System.out.println("start=" + start + " size=" + d.size() + " -> " + b);
        }
    }
}
