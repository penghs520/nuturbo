package cn.nuturbo.common.origintype;

import cn.nuturbo.common.utils.Asserts;

/**
 * Created by penghs at 2023/11/21 15:39
 *
 * 内置关联关系：1、正在工作的卡（仅事项卡）-正在工作的人
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
