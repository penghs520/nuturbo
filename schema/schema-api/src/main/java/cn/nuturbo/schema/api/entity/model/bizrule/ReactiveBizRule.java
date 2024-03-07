package cn.nuturbo.schema.api.entity.model.bizrule;

import cn.nuturbo.common.origintype.CardTypeId;
import cn.nuturbo.common.origintype.ConditionId;
import cn.nuturbo.common.origintype.OrgId;
import cn.nuturbo.common.utils.Asserts;
import cn.nuturbo.schema.api.entity.model.action.ActionItem;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

/**
 * 响应型业务规则：即某事发生时，异步执行某项内置动作来响应之。
 * 这里有3点需要注意：
 * 1、通过执行规则触发的动作，对应的操作历史都要记录下规则id
 * 2、执行规则触发的动作，不会经过前置检查型业务规则的检查
 * 3、循环检测：避免执行规则触发的动作，不会再次触发相同的执行规则，从而导致无限循环
 */
@Getter
public class ReactiveBizRule extends BizRule {

    private final List<ActionItem> executeActionItems;

    @JsonCreator
    protected ReactiveBizRule(@JsonProperty("id") BizRuleId id,
                              @JsonProperty("orgId") OrgId orgId,
                              @JsonProperty("name") String name,
                              @JsonProperty("description") String description,
                              @JsonProperty("cardTypeId") CardTypeId cardTypeId,
                              @JsonProperty("effectCondition") ConditionId effectCondition,
                              @JsonProperty("listenEvent") ListenEvent listenEvent,
                              @JsonProperty("executeActionItems") List<ActionItem> executeActionItems) {
        super(id, orgId, name, description, cardTypeId, effectCondition, listenEvent);
        this.executeActionItems = Asserts.notEmpty(executeActionItems, "executeActionItems is required");
    }
}
