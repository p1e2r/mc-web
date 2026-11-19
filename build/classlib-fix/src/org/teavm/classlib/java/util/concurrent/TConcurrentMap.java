package org.teavm.classlib.java.util.concurrent;

import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * mc-web fix of TeaVM's ConcurrentMap (MIT License): the default methods follow the JDK's specification.
 * TeaVM 0.16's computeIfAbsent returned putIfAbsent's result (null on insert) instead of the new value.
 */
public interface TConcurrentMap<K, V> extends Map<K, V> {
    V putIfAbsent(K key, V value);
    boolean remove(Object key, Object value);
    boolean replace(K key, V oldValue, V newValue);
    V replace(K key, V value);

    @Override
    default V getOrDefault(Object key, V defaultValue) {
        V v;
        return (v = get(key)) != null ? v : defaultValue;
    }

    @Override
    default void forEach(BiConsumer<? super K, ? super V> action) {
        Objects.requireNonNull(action);
        for (Map.Entry<K, V> e : entrySet()) action.accept(e.getKey(), e.getValue());
    }

    @Override
    default void replaceAll(BiFunction<? super K, ? super V, ? extends V> function) {
        Objects.requireNonNull(function);
        for (Map.Entry<K, V> e : entrySet()) {
            K k = e.getKey();
            V v = e.getValue();
            while (!replace(k, v, function.apply(k, v))) {
                if ((v = get(k)) == null) break;
            }
        }
    }

    @Override
    default V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        V oldValue, newValue;
        if ((oldValue = get(key)) != null) return oldValue;
        if ((newValue = mappingFunction.apply(key)) == null) return null;
        V raced = putIfAbsent(key, newValue);
        return raced == null ? newValue : raced;
    }

    @Override
    default V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        for (V oldValue; (oldValue = get(key)) != null; ) {
            V newValue = remappingFunction.apply(key, oldValue);
            if (newValue != null ? replace(key, oldValue, newValue) : remove(key, oldValue)) return newValue;
        }
        return null;
    }

    @Override
    default V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        V oldValue = get(key);
        for (;;) {
            V newValue = remappingFunction.apply(key, oldValue);
            if (newValue != null) {
                if (oldValue != null) {
                    if (replace(key, oldValue, newValue)) return newValue;
                } else if ((oldValue = putIfAbsent(key, newValue)) == null) {
                    return newValue;
                } else {
                    continue;
                }
            } else if (oldValue == null || remove(key, oldValue)) {
                return null;
            }
            oldValue = get(key);
        }
    }

    @Override
    default V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        Objects.requireNonNull(value);
        V oldValue = get(key);
        for (;;) {
            if (oldValue != null) {
                V newValue = remappingFunction.apply(oldValue, value);
                if (newValue != null) {
                    if (replace(key, oldValue, newValue)) return newValue;
                } else if (remove(key, oldValue)) {
                    return null;
                }
                oldValue = get(key);
            } else {
                if ((oldValue = putIfAbsent(key, value)) == null) return value;
            }
        }
    }
}
