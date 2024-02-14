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
 */
@Getter
@Setter
public class IssueType extends VertexType {

    //未开始 进行中 已完成
    //

    private final Set<CardTypeId> inherits;

    public IssueType(CardTypeId id, OrgId orgId, String name, String description, PermissionConfig permissionConfig, Set<CardTypeId> inherits) {
        super(id, orgId, name, description, permissionConfig);
        this.inherits = inherits;
        Asserts.isTrue(CardTypeId.isIssueType(id), "id of issue type must be issue type id.");
    }

    @Override
    public List<SchemaId> secondaryIndexes() {
        if (CollectionUtils.isNotEmpty(inherits))
            return new ArrayList<>(inherits);
        return null;
    }
}
