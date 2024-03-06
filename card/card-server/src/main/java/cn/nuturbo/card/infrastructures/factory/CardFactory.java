package cn.nuturbo.card.infrastructures.factory;

import cn.nuturbo.card.api.entity.model.Card;
import cn.nuturbo.common.origintype.*;
import org.springframework.stereotype.Service;

/**
 * Created by penghs at 2024/2/14 15:16
 */
@Service
public class CardFactory {

    private final CardCodeGenerator cardCodeGenerator;

    public CardFactory(CardCodeGenerator cardCodeGenerator) {
        this.cardCodeGenerator = cardCodeGenerator;
    }

    public Card newCard(String cardName, CardTypeId cardTypeId, OrgId orgId) {
        Long createTime = System.currentTimeMillis();
        return new Card(CardId.newId(), cardTypeId, cardName, orgId, cardCodeGenerator.newCode(orgId), CardState.Active, null, createTime, createTime, null, null, null);
    }

    public Card newIssueCard(String cardName, CardTypeId cardTypeId, OrgId orgId, IssueStatus issueStatus) {
        Long createTime = System.currentTimeMillis();
        return new Card(CardId.newId(), cardTypeId, cardName, orgId, cardCodeGenerator.newCode(orgId), CardState.Active, issueStatus, createTime, createTime, null, null, null);
    }
}
