package cn.nuturbo.query.core.vo;

import cn.nuturbo.common.origintype.OrgID;
import cn.nuturbo.common.origintype.VertexID;
import cn.nuturbo.common.origintype.VertexTypeID;
import cn.nuturbo.common.utils.Asserts;
import lombok.Getter;

import java.util.List;

/**
 * Created by penghs at 2023/11/22 12:46
 */
@Getter
public class QueryContext {

    private final OrgID orgId;
    private final List<VertexTypeID> vtIds;
    private final VertexID memberId;
    private final List<VertexID> vertexScope;

    public QueryContext(OrgID orgId, List<VertexTypeID> vtIds, VertexID memberId, List<VertexID> vertexScope) {
        this.orgId = Asserts.notNull(orgId, "orgId of QueryContext can not be null.");
        this.vtIds = Asserts.notEmpty(vtIds, "vtIds of QueryContext can not be empty.");
        this.memberId = memberId;
        this.vertexScope = vertexScope;
    }
}
