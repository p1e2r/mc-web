package mcweb.rt;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.teavm.jso.JSBody;

/**
 * mc-web (MIT License): generic superclass/interface information for TeaVM, which keeps no Signature attributes.
 * The patcher writes every class's generic signature to sigs.json; the page loads it into LWJGLWeb.sigs and this class
 * parses it into java.lang.reflect types, so Gson's and Guava's TypeToken (new TypeToken<List<String>>() {}) work.
 */
public final class Generics {
    private Generics() { }

    @JSBody(params = "n", script = "var s = LWJGLWeb.sigs; return s && s[n] !== undefined ? s[n] : null;")
    private static native String signatureOf(String className);

    public static Type genericSuperclass(Class<?> c) {
        String sig = signatureOf(c.getName());
        if (sig == null) return c.getSuperclass();
        try {
            Parser p = new Parser(sig);
            p.skipTypeParams();
            return p.fieldType();
        } catch (RuntimeException e) {
            return c.getSuperclass();
        }
    }

    public static Type[] genericInterfaces(Class<?> c) {
        String sig = signatureOf(c.getName());
        if (sig == null) return c.getInterfaces();
        try {
            Parser p = new Parser(sig);
            p.skipTypeParams();
            p.fieldType();
            List<Type> out = new ArrayList<>();
            while (!p.done()) out.add(p.fieldType());
            return out.toArray(new Type[0]);
        } catch (RuntimeException e) {
            return c.getInterfaces();
        }
    }

    static Class<?> load(String binaryName) {
        try {
            return Class.forName(binaryName);
        } catch (Throwable t) {
            return Object.class;
        }
    }

    static final class Parser {
        final String s;
        int i;
        Parser(String s) { this.s = s; }
        boolean done() { return i >= s.length(); }

        void skipTypeParams() {
            if (s.charAt(i) != '<') return;
            int depth = 0;
            do {
                char c = s.charAt(i++);
                if (c == '<') depth++;
                else if (c == '>') depth--;
            } while (depth > 0);
        }

        Type fieldType() {
            char c = s.charAt(i);
            switch (c) {
                case 'L': return classType();
                case 'T': {
                    int semi = s.indexOf(';', i);
                    String name = s.substring(i + 1, semi);
                    i = semi + 1;
                    return Object.class; // type variables are not tracked
                }
                case '[': {
                    i++;
                    Type comp = fieldType();
                    if (comp instanceof Class) return java.lang.reflect.Array.newInstance((Class<?>) comp, 0).getClass();
                    return new GenericArray(comp);
                }
                default:
                    i++;
                    switch (c) {
                        case 'Z': return boolean.class;
                        case 'B': return byte.class;
                        case 'C': return char.class;
                        case 'S': return short.class;
                        case 'I': return int.class;
                        case 'J': return long.class;
                        case 'F': return float.class;
                        case 'D': return double.class;
                        case 'V': return void.class;
                        default: throw new IllegalArgumentException("bad signature " + s);
                    }
            }
        }

        Type classType() {
            i++; // 'L'
            StringBuilder name = new StringBuilder();
            Type owner = null;
            Type current = null;
            while (true) {
                char c = s.charAt(i);
                if (c == ';') { i++; break; }
                if (c == '<') {
                    i++;
                    List<Type> args = new ArrayList<>();
                    while (s.charAt(i) != '>') args.add(typeArgument());
                    i++;
                    Class<?> raw = load(name.toString().replace('/', '.'));
                    current = new Parameterized(raw, args.toArray(new Type[0]), owner);
                } else if (c == '.') {
                    i++;
                    owner = current != null ? current : load(name.toString().replace('/', '.'));
                    current = null;
                    name.append('$');
                } else {
                    name.append(c);
                    i++;
                }
            }
            if (current != null) return current;
            Class<?> raw = load(name.toString().replace('/', '.'));
            return owner instanceof ParameterizedType ? new Parameterized(raw, new Type[0], owner) : raw;
        }

        Type typeArgument() {
            char c = s.charAt(i);
            if (c == '*') { i++; return new Wildcard(new Type[]{Object.class}, new Type[0]); }
            if (c == '+') { i++; return new Wildcard(new Type[]{fieldType()}, new Type[0]); }
            if (c == '-') { i++; return new Wildcard(new Type[]{Object.class}, new Type[]{fieldType()}); }
            return fieldType();
        }
    }

    static String name(Type t) { return t instanceof Class ? ((Class<?>) t).getName() : t.toString(); }

    static final class Parameterized implements ParameterizedType {
        final Class<?> raw; final Type[] args; final Type owner;
        Parameterized(Class<?> raw, Type[] args, Type owner) { this.raw = raw; this.args = args; this.owner = owner; }
        public Type[] getActualTypeArguments() { return args.clone(); }
        public Type getRawType() { return raw; }
        public Type getOwnerType() { return owner; }
        @Override public boolean equals(Object o) {
            if (!(o instanceof ParameterizedType)) return false;
            ParameterizedType p = (ParameterizedType) o;
            return raw.equals(p.getRawType()) && Objects.equals(owner, p.getOwnerType()) && Arrays.equals(args, p.getActualTypeArguments());
        }
        @Override public int hashCode() { return Arrays.hashCode(args) ^ raw.hashCode() ^ Objects.hashCode(owner); }
        @Override public String toString() {
            StringBuilder b = new StringBuilder(raw.getName());
            if (args.length > 0) {
                b.append('<');
                for (int k = 0; k < args.length; k++) { if (k > 0) b.append(", "); b.append(name(args[k])); }
                b.append('>');
            }
            return b.toString();
        }
    }

    static final class Wildcard implements WildcardType {
        final Type[] upper, lower;
        Wildcard(Type[] upper, Type[] lower) { this.upper = upper; this.lower = lower; }
        public Type[] getUpperBounds() { return upper.clone(); }
        public Type[] getLowerBounds() { return lower.clone(); }
        @Override public boolean equals(Object o) {
            return o instanceof WildcardType && Arrays.equals(upper, ((WildcardType) o).getUpperBounds()) && Arrays.equals(lower, ((WildcardType) o).getLowerBounds());
        }
        @Override public int hashCode() { return Arrays.hashCode(upper) ^ Arrays.hashCode(lower); }
        @Override public String toString() {
            if (lower.length > 0) return "? super " + name(lower[0]);
            if (upper.length == 0 || upper[0] == Object.class) return "?";
            return "? extends " + name(upper[0]);
        }
    }

    static final class GenericArray implements GenericArrayType {
        final Type comp;
        GenericArray(Type comp) { this.comp = comp; }
        public Type getGenericComponentType() { return comp; }
        @Override public boolean equals(Object o) { return o instanceof GenericArrayType && comp.equals(((GenericArrayType) o).getGenericComponentType()); }
        @Override public int hashCode() { return comp.hashCode(); }
        @Override public String toString() { return name(comp) + "[]"; }
    }

}
