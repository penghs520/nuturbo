package cn.nuturbo.card.remoteservice;

import cn.nuturbo.card.api.CardRemoteService;
import cn.nuturbo.card.api.request.CreateCardRequest;
import cn.nuturbo.card.infrastructures.factory.CardFactory;
import cn.nuturbo.common.model.Card;
import cn.nuturbo.common.vo.Operator;
import cn.nuturbo.common.vo.Result;
import lombok.NonNull;
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
    public Result<Card> createCard(@NonNull CreateCardRequest createCardRequest, @NonNull Operator operator) throws Exception {
        Card newCard = cardFactory.newCard(createCardRequest.getCardName(), createCardRequest.getCardTypeId(), operator.orgId())
                .setDescription(createCardRequest.getDescription());
        return Result.success(newCard);
    }
}
