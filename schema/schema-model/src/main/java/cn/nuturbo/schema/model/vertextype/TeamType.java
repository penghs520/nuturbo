package cn.nuturbo.schema.model.vertextype;

import cn.nuturbo.common.origintype.OrgID;
import cn.nuturbo.common.origintype.SchemaID;
import cn.nuturbo.common.origintype.VertexTypeID;
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

    private final Set<VertexTypeID> inherits;

    public TeamType(VertexTypeID id, OrgID orgId, String name, String description, PermissionConfig permissionConfig, Set<VertexTypeID> inherits) {
        super(id, orgId, name, description, permissionConfig);
        Asserts.isTrue(VertexTypeID.isTeamType(id), "id of team type must be team type id.");
        this.inherits = inherits;
    }

    @Override
    public List<SchemaID> secondaryIndexes() {
        if (CollectionUtils.isNotEmpty(inherits))
            return new ArrayList<>(inherits);
        return null;
    }
}
