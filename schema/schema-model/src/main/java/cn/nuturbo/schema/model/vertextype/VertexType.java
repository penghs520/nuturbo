package cn.nuturbo.schema.model.vertextype;

import cn.nuturbo.common.origintype.OrgID;
import cn.nuturbo.common.origintype.SchemaID;
import cn.nuturbo.common.origintype.VertexTypeID;
import cn.nuturbo.schema.model.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by penghs at 2023/11/22 22:21
 */
@Getter
@Setter
public abstract class VertexType extends Schema<VertexTypeID> {

    private final PermissionConfig permissionConfig;

    protected VertexType(VertexTypeID id, OrgID orgId, String name, String description, PermissionConfig permissionConfig) {
        super(id, orgId, name, description);
        this.permissionConfig = permissionConfig;
    }


    @Override
    public SchemaID belongTo() {
        return null;
    }

}
