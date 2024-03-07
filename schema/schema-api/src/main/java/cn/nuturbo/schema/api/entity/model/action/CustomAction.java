package cn.nuturbo.schema.api.entity.model.action;

import cn.nuturbo.common.origintype.CardTypeId;
import cn.nuturbo.common.origintype.ConditionId;
import cn.nuturbo.common.origintype.OrgId;
import cn.nuturbo.common.origintype.SchemaId;
import cn.nuturbo.schema.model.Schema;
import lombok.Getter;

import java.util.Collections;
import java.util.List;

/**
 * 自定义动作
 * 设计初衷：希望通过自定义动作来封装一组内置动作项（这组动作并不能原子化），可以简化操作，设计一些简单流程
 * 例如：给版本卡设置一个完成的动作，当点击完成时，将版本卡的状态设置为完成，同时设置版本的完成时间为当前时间
 */
@Getter
public class CustomAction extends Schema<ActionId> {

    private final CardTypeId cardTypeId;

    /**
     * 执行条件：什么人有权限执行，通过过滤来实现
     * 注意：这里的设计初衷是想控制什么人有权限执行，而不要去控制当卡片处于什么状态是才能执行，那是检查型业务规则的事情。因为检查型业务规则既监听自定义动作事件也监听内置动作事件，粒度更小
     */
    private final ConditionId permission;

    // 按顺序执行的动作项
    private final List<ActionItem> executeActionItems;

    protected CustomAction(ActionId id, OrgId orgId, String name, String description, CardTypeId cardTypeId, ConditionId permission, List<ActionItem> executeActionItems) {
        super(id, orgId, name, description);
        this.cardTypeId = cardTypeId;
        this.permission = permission;
        this.executeActionItems = executeActionItems;
    }


    @Override
    public SchemaId belongTo() {
        return cardTypeId;
    }

    @Override
    public List<SchemaId> secondaryIndexes() {
        return Collections.singletonList(cardTypeId);
    }
}
