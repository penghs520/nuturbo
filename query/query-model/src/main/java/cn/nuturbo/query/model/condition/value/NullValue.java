package cn.nuturbo.query.model.condition.value;

/**
 * Created by penghs at 2023/11/22 11:41
 */
public final class NullValue implements Value{

    private static final NullValue INSTANCE = new NullValue();

    private NullValue() {
    }

    public static NullValue getInstance() {
        return INSTANCE;
    }
}
