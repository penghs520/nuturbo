package cn.nuturbo.schema.api.entity.model.bizrule;

import cn.nuturbo.common.origintype.CardTypeId;
import cn.nuturbo.common.origintype.ConditionId;
import cn.nuturbo.common.origintype.OrgId;
import cn.nuturbo.common.origintype.SchemaId;
import cn.nuturbo.schema.model.Schema;
import lombok.Getter;

import java.util.List;

/**
 * TODO 关于更多：1、能不能根据业务规则定义 反向输出业务流程图
 */
@Getter
public abstract class BizRule extends Schema<BizRuleId> {

    // 针对那个卡片类型制定的业务规则
    private final CardTypeId cardTypeId;

    // 生效范围，通过过滤来实现
    private final ConditionId effectCondition;

    // 当发生什么内置动作时触发   注意：不是只看发生了什么事，还要看这件事产生了什么影响或结果  比如回滚事项状态动作，要看具体回滚到哪个状态
    private final ListenEvent listenEvent;

    protected BizRule(BizRuleId id, OrgId orgId, String name, String description, CardTypeId cardTypeId, ConditionId effectCondition, ListenEvent listenEvent) {
        super(id, orgId, name, description);
        this.cardTypeId = cardTypeId;
        this.effectCondition = effectCondition;
        this.listenEvent = listenEvent;
    }

    @Override
    public SchemaId belongTo() {
        return cardTypeId;
    }

    @Override
    public List<SchemaId> secondaryIndexes() {
        return null;
    }
}
