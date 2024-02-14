package cn.nuturbo.common.model;

import cn.nuturbo.common.origintype.*;
import cn.nuturbo.common.utils.Asserts;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    private final Map<CustomFieldId, FieldValue> fieldValueMap;
    private final Map<Path, Set<Card>> relatedCardMap;

    @JsonCreator
    public Card(@JsonProperty("id") CardId id,
                @JsonProperty("cardTypeId") CardTypeId cardTypeId,
                @JsonProperty("name") String name,
                @JsonProperty("orgId") OrgId orgId,
                @JsonProperty("code") String code,
                @JsonProperty("cardState") CardState cardState,
                @JsonProperty("issueStatus") IssueStatus issueStatus,
                @JsonProperty("createTime") Long createTime,
                @JsonProperty("updateTime") Long updateTime,
                @JsonProperty("description") String description,
                @JsonProperty("fieldValueMap") Map<CustomFieldId, FieldValue> fieldValueMap,
                @JsonProperty("relatedCardMap") Map<Path, Set<Card>> relatedCardMap) {
        this.id = Asserts.notNull(id, "id is required");
        this.cardTypeId = Asserts.notNull(cardTypeId, "cardTypeId is required");
        this.name = Asserts.notNull(name, "name is required");
        this.orgId = Asserts.notNull(orgId, "orgId is required");
        this.code = Asserts.notNull(code, "code is required");
        this.cardState = Asserts.notNull(cardState, "cardState of vertex can not be null");
        this.description = description;
        if (CardTypeId.isIssueType(cardTypeId)) {
            this.issueStatus = Asserts.notNull(issueStatus, "issueStatus of issue card can not be null");
        } else {
            this.issueStatus = null;
        }
        this.createTime = Asserts.notNull(createTime, "createTime of vertex can not be null");
        this.updateTime = Asserts.notNull(updateTime, "updateTime of vertex can not be null");
        this.fieldValueMap = fieldValueMap != null ? new HashMap<>(fieldValueMap) : new HashMap<>();
        this.relatedCardMap = relatedCardMap != null ? new HashMap<>(relatedCardMap) : new HashMap<>();
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
