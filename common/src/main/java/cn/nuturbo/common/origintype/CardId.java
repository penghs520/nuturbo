package cn.nuturbo.common.origintype;

import cn.nuturbo.common.utils.Asserts;

/**
 * Created by penghs at 2023/11/21 15:39
 */
public class CardId extends Identity {

    //for se/de
    private CardId() {

    }

    public CardId(String value) {
        super(value);
    }

    @Override
    protected void checkFormat(String id) throws IdentityFormattedException {
        Asserts.isTrue(id.startsWith("c:"), () -> new IdentityFormattedException("CardId 格式错误:%s".formatted(id)));
    }

    public static CardId newId() {
        return new CardId("c:" + randomId());
    }
}
