package cn.nuturbo.schema.api.entity.model.cardtype;

import cn.nuturbo.common.origintype.CardTypeId;
import cn.nuturbo.common.origintype.OrgId;
import cn.nuturbo.common.origintype.SchemaId;
import cn.nuturbo.schema.model.Schema;

import java.util.List;

public class CardType extends Schema<CardTypeId> {

    protected CardType(CardTypeId id, OrgId orgId, String name, String description) {
        super(id, orgId, name, description);
    }

    @Override
    public SchemaId belongTo() {
        return null;
    }

    @Override
    public List<SchemaId> secondaryIndexes() {
        return null;
    }
}
