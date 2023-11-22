package cn.nuturbo.query.model.condition;

import cn.nuturbo.query.model.condition.conditionItem.ConditionItem;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by penghs at 2023/11/22 11:05
 * 支持的最复杂的条件为：
 * a & b
 * & (c | d) & (e | f)
 */
public record Condition(List<ConditionItem<?, ?>> ands, List<LogicCondition> logics) {

    public Condition(List<ConditionItem<?, ?>> ands, List<LogicCondition> logics) {
        this.ands = ands != null ? ands.stream().filter(Objects::nonNull).collect(Collectors.toList()) : new ArrayList<>();
        this.logics = logics != null ? logics.stream().filter(Objects::nonNull).collect(Collectors.toList()) : new ArrayList<>();
    }

    public static Condition newInstance() {
        return new Condition(null, null);
    }

    public Condition and(ConditionItem<?, ?> and) {
        if (and != null) {
            ands.add(and);
        }
        return this;
    }

    public Condition andLogic(LogicCondition logic) {
        if (logic != null) {
            logics.add(logic);
        }
        return this;
    }

}
