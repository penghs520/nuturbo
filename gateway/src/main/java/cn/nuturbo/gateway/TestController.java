package cn.nuturbo.gateway;

import cn.nuturbo.card.api.CardRemoteService;
import cn.nuturbo.card.api.request.CreateCardRequest;
import cn.nuturbo.common.model.Card;
import cn.nuturbo.common.origintype.CardTypeId;
import cn.nuturbo.common.origintype.MemberId;
import cn.nuturbo.common.vo.Response;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {


    @DubboReference
    private CardRemoteService cardRemoteService;

    @RequestMapping("/create-card")
    public Response<Card> hello() {
        MemberId memberId = new MemberId("v:123");
        CardTypeId cardTypeId = new CardTypeId("recordCardType:123");
        return cardRemoteService.createCard(new CreateCardRequest(memberId, cardTypeId, "卡片001", "这是卡片描述", null));
    }
}