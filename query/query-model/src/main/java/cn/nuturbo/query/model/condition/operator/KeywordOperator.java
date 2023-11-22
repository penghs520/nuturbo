package cn.nuturbo.query.model.condition.operator;

import cn.nuturbo.common.utils.Asserts;
import cn.nuturbo.query.model.condition.value.KeywordValue;
import cn.nuturbo.query.model.condition.value.Value;

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
