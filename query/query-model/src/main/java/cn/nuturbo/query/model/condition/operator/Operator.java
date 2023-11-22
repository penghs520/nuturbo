package cn.nuturbo.query.model.condition.operator;

import cn.nuturbo.query.model.condition.value.Value;

/**
 * Created by penghs at 2023/11/22 11:07
 */
public sealed interface Operator permits KeywordOperator, NumberOperator {
    Value getValue();
}
