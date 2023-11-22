package cn.nuturbo.query.core.bo;

import cn.nuturbo.query.model.condition.Condition;
import cn.nuturbo.query.model.condition.LogicCondition;
import cn.nuturbo.query.model.condition.conditionItem.ConditionItem;

import java.util.List;

/**
 * Created by penghs at 2023/11/22 13:24
 */
public record ResolvedCondition(List<ConditionItem<?, ?>> ands, List<LogicCondition> logics) {


}
