package cn.nuturbo.common.origintype;

import cn.nuturbo.common.utils.Asserts;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by penghs at 2023/11/21 15:45
 */
public class CardTypeId extends SchemaId {

    @JsonCreator
    public CardTypeId(@JsonProperty("value") String value) {
        super(value);
    }

    @Override
    public SchemaType schemaType() {
        return SchemaType.VertexType;
    }

    @Override
    protected void checkFormat(String id) throws IdentityFormattedException {
        Asserts.isTrue(id.startsWith("m-card:")
                        || id.startsWith("t-card:")
                        || id.startsWith("i-card:")
                        || id.startsWith("r-card:")
                        || id.startsWith("abs-card:")
                , () -> new IdentityFormattedException("CardTypeId 格式错误: %s".formatted(id)));
    }

    public static boolean isIssueType(CardTypeId vtId) {
        return vtId.value().startsWith("i-card:");
    }

    public static boolean isMemberType(CardTypeId vtId) {
        return vtId.value().startsWith("m-card:");
    }

    public static boolean isTeamType(CardTypeId vtId) {
        return vtId.value().startsWith("t-card:");
    }

    public static boolean isRecordType(CardTypeId vtId) {
        return vtId.value().startsWith("r-card:");
    }

    public static boolean isAbstractType(CardTypeId vtId) {
        return vtId.value().startsWith("abs-card:");
    }
}
