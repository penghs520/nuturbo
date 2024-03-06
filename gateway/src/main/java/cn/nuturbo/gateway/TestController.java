package cn.nuturbo.gateway;

import cn.nuturbo.card.api.CardRemoteService;
import cn.nuturbo.card.api.request.CreateCardRequest;
import cn.nuturbo.card.api.entity.model.Card;
import cn.nuturbo.common.origintype.CardTypeId;
import cn.nuturbo.common.origintype.MemberId;
import cn.nuturbo.common.origintype.OrgId;
import cn.nuturbo.common.vo.Operator;
import cn.nuturbo.common.vo.Result;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {


    @DubboReference
    private CardRemoteService cardRemoteService;

    @RequestMapping("/create-card")
    public Result<Card> hello() {
        MemberId memberId = new MemberId("v:123");
        OrgId orgId = new OrgId("org:123");
        Operator operator = new Operator(memberId, orgId, "penghs");
        CardTypeId cardTypeId = new CardTypeId("recordCardType:123");
        try {
            return cardRemoteService.createCard(new CreateCardRequest(cardTypeId, "卡片001", "这是卡片描述", null), null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}