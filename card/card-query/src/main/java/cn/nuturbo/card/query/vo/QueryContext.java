package cn.nuturbo.card.query.vo;

import cn.nuturbo.common.origintype.OrgId;
import cn.nuturbo.common.origintype.CardId;
import cn.nuturbo.common.origintype.CardTypeId;
import cn.nuturbo.common.utils.Asserts;
import lombok.Getter;

import java.util.List;

/**
 * Created by penghs at 2023/11/22 12:46
 */
@Getter
public class QueryContext {

    private final OrgId orgId;
    private final List<CardTypeId> vtIds;
    private final CardId memberId;
    private final List<CardId> vertexScope;

    public QueryContext(OrgId orgId, List<CardTypeId> vtIds, CardId memberId, List<CardId> vertexScope) {
        this.orgId = Asserts.notNull(orgId, "orgId of QueryContext can not be null.");
        this.vtIds = Asserts.notEmpty(vtIds, "vtIds of QueryContext can not be empty.");
        this.memberId = memberId;
        this.vertexScope = vertexScope;
    }
}
