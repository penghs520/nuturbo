package cn.nuturbo.card.storage;

import cn.nuturbo.card.api.entity.model.Relation;
import cn.nuturbo.common.origintype.RelationTypeId;
import cn.nuturbo.common.origintype.CardId;

/**
 * Created by penghs at 2024/2/13 20:48
 */
public interface RelationMutator {

    void merge(Relation relation);

    void batchMerge(Iterable<Relation> relations);

    void delete(RelationTypeId relationTypeId);

    void delete(CardId cardId);
}
