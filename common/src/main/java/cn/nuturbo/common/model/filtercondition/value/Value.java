package cn.nuturbo.common.model.filtercondition.value;

/**
 * Created by penghs at 2023/11/22 11:07
 */
public sealed interface Value
        permits KeywordValue, NullValue, NumberValue {
}
