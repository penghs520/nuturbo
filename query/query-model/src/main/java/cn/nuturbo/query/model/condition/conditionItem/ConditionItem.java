package cn.nuturbo.query.model.condition.conditionItem;

import cn.nuturbo.common.utils.Asserts;
import cn.nuturbo.query.model.condition.operator.Operator;
import cn.nuturbo.query.model.condition.subject.Subject;
import lombok.Getter;

/**
 * Created by penghs at 2023/11/22 11:05
 */
@Getter
public abstract sealed class ConditionItem<SB extends Subject, OP extends Operator>
        permits KeywordConditionItem, NumberConditionItem {
    private final SB subject;
    private final OP operator;

    protected ConditionItem(SB subject, OP operator) {
        this.subject = Asserts.notNull(subject, "subject of conditionItem can not be null.");
        this.operator = Asserts.notNull(operator, "operator of conditionItem can not be null.");
    }
}
