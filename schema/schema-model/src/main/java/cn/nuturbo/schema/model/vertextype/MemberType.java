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
 * 成员类型
 */
@Getter
@Setter
public class MemberType extends VertexType {

    private final Set<VertexTypeID> inherits;

    public MemberType(VertexTypeID id, OrgID orgId, String name, String description, PermissionConfig permissionConfig, Set<VertexTypeID> inherits) {
        super(id, orgId, name, description, permissionConfig);
        this.inherits = inherits;
        Asserts.isTrue(VertexTypeID.isMemberType(id), "id of member type must be member type id.");
    }

    @Override
    public List<SchemaID> secondaryIndexes() {
        if (CollectionUtils.isNotEmpty(inherits))
            return new ArrayList<>(inherits);
        return null;
    }
}
