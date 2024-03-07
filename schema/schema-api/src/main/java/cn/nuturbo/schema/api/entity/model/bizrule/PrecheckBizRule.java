package cn.nuturbo.schema.api.entity.model.bizrule;

import cn.nuturbo.common.origintype.CardTypeId;
import cn.nuturbo.common.origintype.ConditionId;
import cn.nuturbo.common.origintype.OrgId;
import cn.nuturbo.common.utils.Asserts;
import cn.nuturbo.schema.api.entity.model.action.TemplatedContent;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * 前置检查型业务规则：即执行某动作前，要先满足规则条件
 */
@Getter
public class PrecheckBizRule extends BizRule {

    //也通过过滤来实现
    private final ConditionId condition;

    private final TemplatedContent tip;

    @JsonCreator
    protected PrecheckBizRule(@JsonProperty("id") BizRuleId id,
                              @JsonProperty("orgId") OrgId orgId,
                              @JsonProperty("name") String name,
                              @JsonProperty("description") String description,
                              @JsonProperty("cardTypeId") CardTypeId cardTypeId,
                              @JsonProperty("effectCondition") ConditionId effectCondition,
                              @JsonProperty("listenEvent") ListenEvent listenEvent,
                              @JsonProperty("condition") ConditionId condition,
                              @JsonProperty("tip") TemplatedContent tip) {
        super(id, orgId, name, description, cardTypeId, effectCondition, listenEvent);
        this.condition = Asserts.notNull(condition, "condition is required");
        this.tip = Asserts.notNull(tip, "tip is required");
    }
}
