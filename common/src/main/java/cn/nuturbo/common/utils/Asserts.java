package cn.nuturbo.common.utils;

import java.util.Collection;
import java.util.Map;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Asserts {


    public static <T> T notNull(T object, String message) {
        if (object == null) {
            throw new IllegalArgumentException(message);
        }
        return object;
    }

    public static String notBlank(String text, String message) {
        if (text == null || text.trim().isEmpty()) {
            throw new IllegalArgumentException(message);
        }
        return text;
    }

    public static <T> T[] notEmpty(T[] array, String message) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException(message);
        }
        return array;
    }

    public static <T extends Collection<?>> T notEmpty(T collection, String message) {
        if (collection == null || collection.isEmpty()) {
            throw new IllegalArgumentException(message);
        }
        return collection;
    }

    public static Map<?, ?> notEmpty(Map<?, ?> map, String message) {
        if (map == null || map.isEmpty()) {
            throw new IllegalArgumentException(message);
        }
        return map;
    }

    public static void isTrue(boolean assertion, String message) {
        if (!assertion) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void isTrue(boolean assertion, Supplier<RuntimeException> exceptionSupplier) {
        if (!assertion) {
            throw exceptionSupplier.get();
        }
    }

    public static <T> T isTrue(T t, Predicate<T> tPredicate, String message) {
        if (!tPredicate.test(t)) {
            throw new IllegalArgumentException(message);
        }
        return t;
    }

}

