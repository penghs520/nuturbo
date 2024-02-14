package cn.nuturbo.common.origintype;

import cn.nuturbo.common.utils.Asserts;

/**
 * Created by penghs at 2023/11/21 15:39
 */
public class RelationTypeId extends Identity {

    //for se/de
    private RelationTypeId() {

    }

    public RelationTypeId(String value) {
        super(value);
    }

    @Override
    protected void checkFormat(String id) throws IdentityFormattedException {
        Asserts.isTrue(id.startsWith("r:"), () -> new IdentityFormattedException("RelationTypeId 格式错误:%s".formatted(id)));
    }
}
