package cn.nuturbo.common.entity;

import cn.nuturbo.common.origintype.*;
import cn.nuturbo.common.utils.Asserts;
import lombok.Getter;

import java.util.Map;
import java.util.Set;

/**
 * Created by penghs at 2023/11/21 17:10
 */
@Getter
public class Vertex {
    private final VertexID id;
    private final VertexTypeID vtId;
    private final Name name;
    private final OrgID orgId;
    private final String code;
    private final VertexState vertexState;
    private final IssueStatus issueStatus;
    private final Long createTime;
    private final Long updateTime;
    private final String discardReason;
    private final Map<FieldID, FieldValue> fieldValueMap;
    private final Map<Path, Set<Vertex>> relatedVertexMap;

    public Vertex(VertexID id, VertexTypeID vtId, Name name, OrgID orgId, String code, VertexState vertexState, IssueStatus issueStatus, Long createTime, Long updateTime, String discardReason, Map<FieldID, FieldValue> fieldValueMap, Map<Path, Set<Vertex>> relatedVertexMap) {
        this.id = Asserts.notNull(id, "id of vertex can not be null");
        this.vtId = Asserts.notNull(vtId, "vtId of vertex can not be null");
        this.name = Asserts.notNull(name, "name of vertex can not be null");
        this.orgId = Asserts.notNull(orgId, "orgId of vertex can not be null");
        this.code = Asserts.notNull(code, "code of vertex can not be null");
        this.vertexState = Asserts.notNull(vertexState, "vertexState of vertex can not be null");
        if (isIssueVertex()) {
            this.issueStatus = Asserts.notNull(issueStatus, "issueStatus of issue vertex can not be null");
        } else {
            this.issueStatus = null;
        }
        this.createTime = Asserts.notNull(createTime, "createTime of vertex can not be null");
        this.updateTime = Asserts.notNull(updateTime, "updateTime of vertex can not be null");
        this.discardReason = discardReason;
        this.fieldValueMap = fieldValueMap;
        this.relatedVertexMap = relatedVertexMap;
    }

    public boolean isIssueVertex() {
        return VertexTypeID.isIssueType(vtId);
    }
}
