package cn.nuturbo.card.storage;

import cn.nuturbo.card.api.entity.model.Card;
import cn.nuturbo.common.origintype.CardId;

/**
 * Created by penghs at 2024/2/13 19:18
 */
public interface VertexMutator {

    void insert(Card vertex);

    void merge(Card vertex);

    void update(Card vertex);

    void delete(CardId cardId);
}
