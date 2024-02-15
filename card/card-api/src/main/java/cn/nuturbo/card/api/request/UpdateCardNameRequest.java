package cn.nuturbo.card.api.request;

import cn.nuturbo.common.utils.Asserts;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * Created by penghs at 2024/2/14 11:09
 */
@Getter
public class UpdateCardNameRequest {

    private final String cardName;

    @JsonCreator
    protected UpdateCardNameRequest(@JsonProperty("cardName") String cardName) {
        this.cardName = Asserts.notNull(cardName, "cardName is required");
    }
}
