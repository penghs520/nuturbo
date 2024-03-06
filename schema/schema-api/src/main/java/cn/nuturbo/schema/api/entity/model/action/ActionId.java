package cn.nuturbo.schema.api.entity.model.action;

import cn.nuturbo.common.origintype.SchemaId;
import cn.nuturbo.common.origintype.SchemaType;

public class ActionId extends SchemaId {

    //for se/de
    private ActionId() {
    }

    public ActionId(String value) {
        super(value);
    }

    @Override
    protected void checkFormat(String id) throws IdentityFormattedException {

    }

    @Override
    public SchemaType schemaType() {
        return null;
    }
}
