package cn.nuturbo.schema.model.vertextype;

import cn.nuturbo.common.origintype.OrgId;
import cn.nuturbo.common.origintype.SchemaId;
import cn.nuturbo.common.origintype.CardTypeId;
import cn.nuturbo.common.utils.Asserts;
import cn.nuturbo.common.utils.CollectionUtils;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by penghs at 2023/11/22 22:24
 * 团队类型，用来创建团队卡，团队类型可以用来创建架构线、应用配置方案
 */
@Getter
@Setter
public class TeamType extends VertexType {

    private final Set<CardTypeId> inherits;

    public TeamType(CardTypeId id, OrgId orgId, String name, String description, PermissionConfig permissionConfig, Set<CardTypeId> inherits) {
        super(id, orgId, name, description, permissionConfig);
        Asserts.isTrue(CardTypeId.isTeamType(id), "id of team type must be team type id.");
        this.inherits = inherits;
    }

    @Override
    public List<SchemaId> secondaryIndexes() {
        if (CollectionUtils.isNotEmpty(inherits))
            return new ArrayList<>(inherits);
        return null;
    }
}
