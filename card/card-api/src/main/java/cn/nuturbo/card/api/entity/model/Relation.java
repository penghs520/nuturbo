package cn.nuturbo.card.api.entity.model;

import cn.nuturbo.common.origintype.RelationTypeId;
import cn.nuturbo.common.origintype.CardId;
import cn.nuturbo.common.utils.Asserts;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * Created by penghs at 2024/2/13 20:49
 */
public record Relation(CardId src, CardId dst, RelationTypeId relationTypeId) {

    @JsonCreator
    public Relation(@JsonProperty("src") CardId src, @JsonProperty("dst") CardId dst, @JsonProperty("relationTypeId") RelationTypeId relationTypeId) {
        this.src = Asserts.notNull(src, "src is required");
        this.dst = Asserts.notNull(dst, "dst is required");
        this.relationTypeId = Asserts.notNull(relationTypeId, "relationTypeId is required");
    }
}
