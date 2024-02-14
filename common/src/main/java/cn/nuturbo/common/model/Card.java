package cn.nuturbo.common.model;

import cn.nuturbo.common.origintype.*;
import cn.nuturbo.common.utils.Asserts;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by penghs at 2023/11/21 17:10
 */
@Getter
public class Card {
    private final CardId id;
    private final CardTypeId cardTypeId;
    private String name;
    private final OrgId orgId;
    private final String code;
    private CardState cardState;
    private IssueStatus issueStatus;
    private final Long createTime;
    private Long updateTime;
    private String description;
    private final Map<FieldId, FieldValue> fieldValueMap;
    private final Map<Path, Set<Card>> relatedCardMap;

    public Card(CardId id, CardTypeId cardTypeId, String name, OrgId orgId, String code, CardState cardState, IssueStatus issueStatus, Long createTime, Long updateTime, String description, Map<FieldId, FieldValue> fieldValueMap, Map<Path, Set<Card>> relatedCardMap) {
        this.id = Asserts.notNull(id, "id is required");
        this.cardTypeId = Asserts.notNull(cardTypeId, "cardTypeId is required");
        this.name = Asserts.notNull(name, "name is required");
        this.orgId = Asserts.notNull(orgId, "orgId is required");
        this.code = Asserts.notNull(code, "code is required");
        this.cardState = Asserts.notNull(cardState, "cardState of vertex can not be null");
        this.description = description;
        if (isIssueCard()) {
            this.issueStatus = Asserts.notNull(issueStatus, "issueStatus of issue card can not be null");
        } else {
            this.issueStatus = null;
        }
        this.createTime = Asserts.notNull(createTime, "createTime of vertex can not be null");
        this.updateTime = Asserts.notNull(updateTime, "updateTime of vertex can not be null");
        this.fieldValueMap = fieldValueMap != null ? new HashMap<>(fieldValueMap) : new HashMap<>();
        this.relatedCardMap = relatedCardMap != null ? new HashMap<>(relatedCardMap) : new HashMap<>();
    }

    public boolean isIssueCard() {
        return CardTypeId.isIssueType(cardTypeId);
    }

    public Card setName(String name) {
        this.name = name;
        return this;
    }

    public Card setCardState(CardState cardState) {
        this.cardState = cardState;
        return this;
    }

    public Card setIssueStatus(IssueStatus issueStatus) {
        this.issueStatus = issueStatus;
        return this;
    }

    public Card setDescription(String description) {
        this.description = description;
        return this;
    }

    public Card setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
        return this;
    }
}
