package cn.nuturbo.common.origintype;

import cn.nuturbo.common.utils.Asserts;

/**
 * Created by penghs at 2023/11/21 15:55
 */
public final class RelationFieldId extends Identity implements FieldId {

    //for se/de
    private RelationFieldId() {

    }

    public RelationFieldId(String value) {
        super(value);
    }

    @Override
    protected void checkFormat(String id) throws IdentityFormattedException {
        //fd:rs:xxx>
        Asserts.isTrue(id.startsWith("fd-r:") || id.endsWith(">") || id.endsWith("<"), () -> new IdentityFormattedException("RelatedFieldId 格式错误: %s".formatted(id)));
    }

    public RelationTypeId relationTypeId() {
        return new RelationTypeId(value().substring(3, value().length() - 1));
    }

}
