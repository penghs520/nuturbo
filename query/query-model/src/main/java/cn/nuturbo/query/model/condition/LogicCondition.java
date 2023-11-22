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
public record LogicCondition(List<ConditionItem<?, ?>> logicItems) {

    public LogicCondition(List<ConditionItem<?, ?>> logicItems) {
        Asserts.notNull(logicItems, "logicItems of LogicCondition can not be null.");
        this.logicItems = logicItems.stream().filter(Objects::nonNull).collect(Collectors.toList());
    }

    public static LogicCondition newInstance() {
        return new LogicCondition(Collections.emptyList());
    }

    public LogicCondition and(ConditionItem<?, ?> and) {
        if (and != null) {
            logicItems.add(and);
        }
        return this;
    }
}
