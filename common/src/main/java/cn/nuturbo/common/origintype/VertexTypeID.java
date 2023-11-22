package cn.nuturbo.common.origintype;

import cn.nuturbo.common.utils.Asserts;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by penghs at 2023/11/21 15:45
 */
public class VertexTypeID extends SchemaID {

    @JsonCreator
    public VertexTypeID(@JsonProperty("value") String value) {
        super(value);
    }

    @Override
    SchemaType schemaType() {
        return SchemaType.VertexType;
    }

    @Override
    protected void checkFormat(String id) throws IdentityFormattedException {
        Asserts.isTrue(id.startsWith("vt-member:")
                        || id.startsWith("vt-team:")
                        || id.startsWith("vt-issue:")
                        || id.startsWith("vt-record:")
                        || id.startsWith("vt-abstract:")
                , () -> new IdentityFormattedException("VertexTypeID 格式错误: %s".formatted(id)));
    }

    public static boolean isIssueType(VertexTypeID vtId) {
        return vtId.value().startsWith("vt-issue:");
    }

    public static boolean isMemberType(VertexTypeID vtId) {
        return vtId.value().startsWith("vt-member:");
    }

    public static boolean isTeamType(VertexTypeID vtId) {
        return vtId.value().startsWith("vt-team:");
    }

    public static boolean isRecordType(VertexTypeID vtId) {
        return vtId.value().startsWith("vt-record:");
    }

    public static boolean isAbstractType(VertexTypeID vtId) {
        return vtId.value().startsWith("vt-abstract:");
    }
}
