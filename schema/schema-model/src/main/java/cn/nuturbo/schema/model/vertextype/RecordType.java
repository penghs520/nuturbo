package cn.nuturbo.schema.model.vertextype;

import cn.nuturbo.common.origintype.OrgID;
import cn.nuturbo.common.origintype.SchemaID;
import cn.nuturbo.common.origintype.VertexTypeID;
import cn.nuturbo.common.utils.Asserts;
import cn.nuturbo.common.utils.CollectionUtils;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by penghs at 2023/11/22 22:24
 * 记录类型，用来创建不可变更的某种记录，如打卡记录、工时指标等
 */
@Getter
public class RecordType extends VertexType {

    private final Set<VertexTypeID> inherits;

    protected RecordType(VertexTypeID id, OrgID orgId, String name, String description, PermissionConfig permissionConfig, Set<VertexTypeID> inherits) {
        super(id, orgId, name, description, permissionConfig);
        this.inherits = inherits;
        Asserts.isTrue(VertexTypeID.isRecordType(id), "id of record type must be record type id.");
    }

    @Override
    public List<SchemaID> secondaryIndexes() {
        if (CollectionUtils.isNotEmpty(inherits))
            return new ArrayList<>(inherits);
        return null;
    }
}
