package cn.nuturbo.query.model.condition.conditionItem;

import cn.nuturbo.query.model.condition.operator.KeywordOperator;
import cn.nuturbo.query.model.condition.subject.KeywordSubject;

/**
 * Created by penghs at 2023/11/22 11:19
 */
public non-sealed class KeywordConditionItem extends ConditionItem<KeywordSubject, KeywordOperator> {


    protected KeywordConditionItem(KeywordSubject subject, KeywordOperator operator) {
        super(subject, operator);
    }
}
