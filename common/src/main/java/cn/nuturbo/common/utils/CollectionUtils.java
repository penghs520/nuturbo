package cn.nuturbo.common.utils;

import java.util.Map;
import java.util.Objects;
import java.util.stream.StreamSupport;

/**
 * Created by penghs at 2023/6/29 14:06
 */
public class CollectionUtils {

    public static boolean isEmpty(Object[] array) {
        return array == null || array.length == 0;
    }

    public static boolean isEmpty(Iterable<?> iterable) {
        return iterable == null || !iterable.iterator().hasNext();
    }

    /**
     * 判断iterable是否为空，如果iterable中的元素都为null，也认为是
     */
    public static boolean isEmptyIgnoreNull(Iterable<?> iterable) {
        return isEmpty(iterable) || StreamSupport.stream(iterable.spliterator(), false).allMatch(Objects::isNull);
    }

    public static boolean isNotEmptyIgnoreNull(Iterable<?> iterable) {
        return !isEmptyIgnoreNull(iterable);
    }

    public static boolean isEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    public static boolean isNotEmpty(Object[] array) {
        return !isEmpty(array);
    }

    public static boolean isNotEmpty(Iterable<?> iterable) {
        return !isEmpty(iterable);
    }

    public static boolean isNotEmpty(Map<?, ?> map) {
        return !isEmpty(map);
    }

}
