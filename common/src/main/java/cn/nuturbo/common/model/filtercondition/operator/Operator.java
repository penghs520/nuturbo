package cn.nuturbo.common.model.filtercondition.operator;

import cn.nuturbo.common.model.filtercondition.value.Value;

/**
 * Created by penghs at 2023/11/22 11:07
 */
public sealed interface Operator permits KeywordOperator, NumberOperator {
    Value getValue();
}
