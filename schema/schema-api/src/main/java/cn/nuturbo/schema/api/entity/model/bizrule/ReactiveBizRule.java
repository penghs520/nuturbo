package cn.nuturbo.schema.api.entity.model.bizrule;

import cn.nuturbo.common.origintype.CardTypeId;
import cn.nuturbo.common.origintype.ConditionId;
import cn.nuturbo.common.origintype.OrgId;
import cn.nuturbo.schema.api.entity.model.action.InternalAction;
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

    private final List<InternalAction> executeActions;

    protected ReactiveBizRule(BizRuleId id, OrgId orgId, String name, String description, CardTypeId cardTypeId, ConditionId effectCondition, ListenEvent listenEvent, List<InternalAction> executeActions) {
        super(id, orgId, name, description, cardTypeId, effectCondition, listenEvent);
        this.executeActions = executeActions;
    }
}
