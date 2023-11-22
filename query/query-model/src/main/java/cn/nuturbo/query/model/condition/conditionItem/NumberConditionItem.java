package cn.nuturbo.query.model.condition.conditionItem;

import cn.nuturbo.query.model.condition.operator.NumberOperator;
import cn.nuturbo.query.model.condition.subject.NumberSubject;

/**
 * Created by penghs at 2023/11/22 12:00
 */
public final class NumberConditionItem extends ConditionItem<NumberSubject, NumberOperator> {

    public NumberConditionItem(NumberSubject subject, NumberOperator operator) {
        super(subject, operator);
    }

    @Override
    public String toString() {
        return "NumberConditionItem{}";
    }
}
