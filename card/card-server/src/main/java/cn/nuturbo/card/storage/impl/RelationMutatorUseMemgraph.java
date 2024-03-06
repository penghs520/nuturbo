package cn.nuturbo.card.storage.impl;

import cn.nuturbo.card.storage.RelationMutator;
import cn.nuturbo.card.api.entity.model.Relation;
import cn.nuturbo.common.origintype.RelationTypeId;
import cn.nuturbo.common.origintype.CardId;

/**
 * Created by penghs at 2024/2/13 21:41
 */
public class RelationMutatorUseMemgraph implements RelationMutator {
    @Override
    public void merge(Relation relation) {

    }

    @Override
    public void batchMerge(Iterable<Relation> relations) {

    }

    @Override
    public void delete(RelationTypeId relationTypeId) {

    }

    @Override
    public void delete(CardId cardId) {

    }
}
