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
    protected void checkFormat(String id) throws IdentityFormattedException {
        Asserts.isTrue(id.startsWith("vt:"), () -> new IdentityFormattedException("VertexTypeID 格式错误: %s".formatted(id)));
    }
}
