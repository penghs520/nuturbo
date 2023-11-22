package cn.nuturbo.query.model.condition;

import cn.nuturbo.common.utils.Asserts;
import cn.nuturbo.query.model.condition.conditionItem.ConditionItem;
import lombok.Getter;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
        this.conditionItems = conditionItems.stream().filter(Objects::nonNull).collect(Collectors.toList());
    }

    public static LogicCondition newInstance(LogicalOperator logicalOperator) {
        return new LogicCondition(logicalOperator, Collections.emptyList());
    }

    public LogicCondition and(ConditionItem<?, ?> and) {
        if (and != null) {
            conditionItems.add(and);
        }
        return this;
    }
}
