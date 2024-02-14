package cn.nuturbo.common.origintype;

import cn.nuturbo.common.utils.Asserts;

/**
 * Created by penghs at 2023/11/22 19:01
 */
public final class CustomFieldId extends SchemaId implements FieldId {

    public CustomFieldId(String value) {
        super(value);
    }

    @Override
    public SchemaType schemaType() {
        return SchemaType.CustomField;
    }

    @Override
    protected void checkFormat(String id) throws IdentityFormattedException {
        Asserts.isTrue(id.startsWith("fd:"), () -> new IdentityFormattedException("CustomFieldId 格式错误: %s".formatted(id)));
    }
}
