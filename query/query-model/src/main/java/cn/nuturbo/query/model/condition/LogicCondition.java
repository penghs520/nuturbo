package cn.nuturbo.query.model.condition;

import cn.nuturbo.common.utils.Asserts;
import cn.nuturbo.query.model.condition.conditionItem.ConditionItem;
import lombok.Getter;

import java.util.List;
import java.util.Objects;

/**
 * Created by penghs at 2023/11/22 12:07
 */
@Getter
public class LogicCondition {
    private final LogicalOperator logicalOperator;
    private final List<ConditionItem<?, ?>> conditionItems;

    public LogicCondition(LogicalOperator logicalOperator, List<ConditionItem<?, ?>> conditionItems) {
        this.logicalOperator = Asserts.notNull(logicalOperator, "logicalOperator of LogicCondition can not be null.");
        Asserts.notNull(conditionItems, "conditionItems of LogicCondition can not be null.");
        this.conditionItems = conditionItems.stream().filter(Objects::nonNull).toList();
    }
}
