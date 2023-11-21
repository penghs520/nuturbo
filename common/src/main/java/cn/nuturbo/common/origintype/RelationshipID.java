package cn.nuturbo.common.origintype;

import cn.nuturbo.common.utils.Asserts;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by penghs at 2023/11/21 15:59
 */
public class RelationshipID extends SchemaID {

    @JsonCreator
    public RelationshipID(@JsonProperty("value") String value) {
        super(value);
    }

    @Override
    protected void checkFormat(String id) throws IdentityFormattedException {
        Asserts.isTrue(id.startsWith("rs:"), () -> new IdentityFormattedException("RelationshipID 格式错误: %s".formatted(id)));
    }
}
