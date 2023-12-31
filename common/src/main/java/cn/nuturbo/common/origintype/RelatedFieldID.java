package cn.nuturbo.common.origintype;

import cn.nuturbo.common.utils.Asserts;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by penghs at 2023/11/21 15:55
 */
public final class RelatedFieldID extends Identity implements FieldID {

    @JsonCreator
    public RelatedFieldID(@JsonProperty("value") String value) {
        super(value);
    }

    @Override
    protected void checkFormat(String id) throws IdentityFormattedException {
        //fd:rs:xxx>
        Asserts.isTrue(id.startsWith("fd:rs:") || id.endsWith(">") || id.endsWith("<"), () -> new IdentityFormattedException("RelatedFieldID 格式错误: %s".formatted(id)));
    }

    public String relationshipId() {
        return value().substring(3, value().length() - 1);
    }

}
