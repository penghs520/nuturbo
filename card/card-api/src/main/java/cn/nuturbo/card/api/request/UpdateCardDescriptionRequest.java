package cn.nuturbo.card.api.request;

import cn.nuturbo.common.origintype.MemberId;
import cn.nuturbo.common.utils.Asserts;
import cn.nuturbo.common.vo.BaseRequest;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * Created by penghs at 2024/2/14 11:09
 */
@Getter
public class UpdateCardDescriptionRequest extends BaseRequest {

    private final String description;

    @JsonCreator
    protected UpdateCardDescriptionRequest(@JsonProperty("memberId") MemberId memberId, @JsonProperty("description") String description) {
        super(memberId);
        this.description = description;
    }
}
