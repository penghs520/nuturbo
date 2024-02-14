package cn.nuturbo.common.origintype;

import cn.nuturbo.common.utils.Asserts;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by penghs at 2023/11/21 15:45
 */
public class CardTypeId extends SchemaId {

    //for se/de
    private CardTypeId() {

    }

    public CardTypeId(String value) {
        super(value);
    }

    @Override
    public SchemaType schemaType() {
        return SchemaType.VertexType;
    }

    @Override
    protected void checkFormat(String id) throws IdentityFormattedException {
        Asserts.isTrue(id.startsWith("memberCardType:")
                        || id.startsWith("teamCardType:")
                        || id.startsWith("issueCardType:")
                        || id.startsWith("recordCardType:")
                        || id.startsWith("absCardType:")
                , () -> new IdentityFormattedException("CardTypeId 格式错误: %s".formatted(id)));
    }

    public static boolean isIssueType(CardTypeId vtId) {
        return vtId.value().startsWith("issueCardType:");
    }

    public static boolean isMemberType(CardTypeId vtId) {
        return vtId.value().startsWith("memberCardType:");
    }

    public static boolean isTeamType(CardTypeId vtId) {
        return vtId.value().startsWith("teamCardType:");
    }

    public static boolean isRecordType(CardTypeId vtId) {
        return vtId.value().startsWith("recordCardType:");
    }

    public static boolean isAbstractType(CardTypeId vtId) {
        return vtId.value().startsWith("absCardType:");
    }
}
