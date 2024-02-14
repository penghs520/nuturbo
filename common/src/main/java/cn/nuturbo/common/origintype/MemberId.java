package cn.nuturbo.common.origintype;

import cn.nuturbo.common.utils.Asserts;

/**
 * Created by penghs at 2023/11/21 15:39
 */
public class MemberId extends Identity {

    //for se/de
    private MemberId() {

    }

    public MemberId(String value) {
        super(value);
    }

    @Override
    protected void checkFormat(String id) throws IdentityFormattedException {
        Asserts.isTrue(id.startsWith("v:"), () -> new IdentityFormattedException("MemberId 格式错误:%s".formatted(id)));
    }
}
