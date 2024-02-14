package cn.nuturbo.card.remoteservice;

import cn.nuturbo.card.api.CardRemoteService;
import cn.nuturbo.card.api.request.CreateCardRequest;
import cn.nuturbo.card.infrastructures.factory.CardFactory;
import cn.nuturbo.common.model.Card;
import cn.nuturbo.common.origintype.OrgId;
import cn.nuturbo.common.vo.Response;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * Created by penghs at 2024/2/14 15:12
 */
@DubboService

public class CardRemoteServiceProvider implements CardRemoteService {

    private final CardFactory cardFactory;

    public CardRemoteServiceProvider(CardFactory cardFactory) {
        this.cardFactory = cardFactory;
    }

    @Override
    public Response<Card> createCard(CreateCardRequest createCardRequest) {
        //TODO 根据成员id拿到组织id
        OrgId orgId = new OrgId("org:1024");
        Card newCard = cardFactory.newCard(createCardRequest.getCardName(), createCardRequest.getCardTypeId(), orgId);
        return Response.success(newCard);
    }
}
