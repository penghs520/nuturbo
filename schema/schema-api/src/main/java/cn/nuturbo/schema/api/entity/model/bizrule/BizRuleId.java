package cn.nuturbo.schema.api.entity.model.bizrule;

import cn.nuturbo.common.origintype.SchemaId;
import cn.nuturbo.common.origintype.SchemaType;

public class BizRuleId extends SchemaId {

    @Override
    protected void checkFormat(String id) throws IdentityFormattedException {

    }

    @Override
    public SchemaType schemaType() {
        return SchemaType.BizRule;
    }
}
