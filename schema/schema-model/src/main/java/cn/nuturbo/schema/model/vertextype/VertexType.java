package cn.nuturbo.schema.model.vertextype;

import cn.nuturbo.common.origintype.OrgId;
import cn.nuturbo.common.origintype.SchemaId;
import cn.nuturbo.common.origintype.CardTypeId;
import cn.nuturbo.schema.model.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by penghs at 2023/11/22 22:21
 */
@Getter
@Setter
public abstract class VertexType extends Schema<CardTypeId> {

    private final PermissionConfig permissionConfig;

    protected VertexType(CardTypeId id, OrgId orgId, String name, String description, PermissionConfig permissionConfig) {
        super(id, orgId, name, description);
        this.permissionConfig = permissionConfig;
    }

    @Override
    public SchemaId belongTo() {
        return null;
    }

}
