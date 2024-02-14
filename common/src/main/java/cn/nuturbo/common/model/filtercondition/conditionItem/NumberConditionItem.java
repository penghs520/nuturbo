package cn.nuturbo.common.model.filtercondition.conditionItem;

import cn.nuturbo.common.model.filtercondition.operator.NumberOperator;
import cn.nuturbo.common.model.filtercondition.subject.NumberSubject;

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
