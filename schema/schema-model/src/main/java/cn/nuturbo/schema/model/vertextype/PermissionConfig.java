package cn.nuturbo.schema.model.vertextype;

import cn.nuturbo.common.origintype.ConditionId;
import cn.nuturbo.schema.model.PromptTemplate;
import lombok.Getter;

/**
 * Created by penghs at 2023/11/22 23:46
 */
@Getter
public class PermissionConfig {



    //TODO 字段权限、卡片操作权限

    private final ConditionId conditionId;

    private final PromptTemplate promptTemplate;

    public PermissionConfig(ConditionId conditionId, PromptTemplate promptTemplate) {
        this.conditionId = conditionId;
        this.promptTemplate = promptTemplate;
    }
}
