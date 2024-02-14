package cn.nuturbo.card.query.bo;

import cn.nuturbo.common.model.filtercondition.LogicCondition;
import cn.nuturbo.common.model.filtercondition.conditionItem.ConditionItem;

import java.util.List;

/**
 * Created by penghs at 2023/11/22 13:24
 */
public record ResolvedCondition(List<ConditionItem<?, ?>> ands, List<LogicCondition> logics) {


}
