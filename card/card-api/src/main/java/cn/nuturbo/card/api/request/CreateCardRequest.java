package cn.nuturbo.card.api.request;

import cn.nuturbo.card.api.dto.FieldValueDTO;
import cn.nuturbo.common.origintype.CardTypeId;
import cn.nuturbo.common.utils.Asserts;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

/**
 * Created by penghs at 2024/2/14 6:19
 * 创建卡片请求
 */
@Getter
public class CreateCardRequest {

    private final CardTypeId cardTypeId;
    private final String cardName;
    private final String description;
    private final List<FieldValueDTO> fieldValues;

    @JsonCreator
    public CreateCardRequest(@JsonProperty("cardTypeId") CardTypeId cardTypeId,
                             @JsonProperty("cardName") String cardName,
                             @JsonProperty("description") String description,
                             @JsonProperty("fieldValues") List<FieldValueDTO> fieldValues) {
        this.cardTypeId = Asserts.notNull(cardTypeId, "cardTypeId is required");
        this.cardName = Asserts.notNull(cardName, "cardName is required");
        this.description = description;
        this.fieldValues = fieldValues;
    }
}
