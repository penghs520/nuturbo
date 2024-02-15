package cn.nuturbo.card.api.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * Created by penghs at 2024/2/14 11:09
 */
@Getter
public class UpdateCardDescriptionRequest {

    private final String description;

    @JsonCreator
    protected UpdateCardDescriptionRequest(@JsonProperty("description") String description) {
        this.description = description;
    }
}
