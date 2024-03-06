package cn.nuturbo.schema.api.entity.model.bizrule;

import cn.nuturbo.common.origintype.CardTypeId;
import cn.nuturbo.common.origintype.ConditionId;
import cn.nuturbo.common.origintype.OrgId;
import lombok.Getter;

/**
 * 前置检查型业务规则：即执行某动作前，要先满足规则条件
 */
@Getter
public class PrecheckBizRule extends BizRule {

    //也通过过滤来实现
    private final ConditionId condition;

    protected PrecheckBizRule(BizRuleId id, OrgId orgId, String name, String description, CardTypeId cardTypeId, ConditionId effectCondition, ListenEvent listenEvent, ConditionId condition) {
        super(id, orgId, name, description, cardTypeId, effectCondition, listenEvent);
        this.condition = condition;
    }
}
