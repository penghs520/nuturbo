package cn.nuturbo.schema.model.vertextype;

import cn.nuturbo.common.origintype.OrgID;
import cn.nuturbo.common.origintype.SchemaID;
import cn.nuturbo.common.origintype.VertexTypeID;
import cn.nuturbo.common.utils.Asserts;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by penghs at 2023/11/22 22:24
 * 该类型只能被其他普通类型所继承，以获得共同的属性（包括关联属性）、行为
 */
@Getter
@Setter
public class AbstractType extends VertexType {

    public AbstractType(VertexTypeID id, OrgID orgId, String name, String description, PermissionConfig permissionConfig) {
        super(id, orgId, name, description, permissionConfig);
        Asserts.isTrue(VertexTypeID.isAbstractType(id), "id of abstract type must be abstract type id.");
    }

    @Override
    public List<SchemaID> secondaryIndexes() {
        return null;
    }
}
