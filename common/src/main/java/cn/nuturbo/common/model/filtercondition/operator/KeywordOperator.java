package cn.nuturbo.common.model.filtercondition.operator;

import cn.nuturbo.common.utils.Asserts;
import cn.nuturbo.common.model.filtercondition.value.KeywordValue;
import cn.nuturbo.common.model.filtercondition.value.Value;

/**
 * Created by penghs at 2023/11/22 11:20
 */
public non-sealed class KeywordOperator implements Operator {

    private final KeywordValue value;

    public KeywordOperator(KeywordValue value) {
        this.value = Asserts.notNull(value, "value of KeywordOperator can not be null");
    }

    @Override
    public Value getValue() {
        return value;
    }
}
