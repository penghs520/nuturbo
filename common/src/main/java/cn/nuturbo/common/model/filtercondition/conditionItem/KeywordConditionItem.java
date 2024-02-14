package cn.nuturbo.common.model.filtercondition.conditionItem;

import cn.nuturbo.common.model.filtercondition.operator.KeywordOperator;
import cn.nuturbo.common.model.filtercondition.subject.KeywordSubject;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by penghs at 2023/11/22 11:19
 * ps: 关键字条件项
 * TODO：参考谷歌搜索  支持精准匹配
 *       title:x
 *       content:x
 *       code:x
 *       creator:x
 */
public non-sealed class KeywordConditionItem extends ConditionItem<KeywordSubject, KeywordOperator> {

    @JsonCreator
    public KeywordConditionItem(@JsonProperty("subject") KeywordSubject subject, @JsonProperty("operator") KeywordOperator operator) {
        super(subject, operator);
    }
}
