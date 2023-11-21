package cn.nuturbo.common.origintype;

import cn.nuturbo.common.utils.Asserts;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by penghs at 2023/11/21 17:19
 */
public class OrgID extends Identity {

    @JsonCreator
    public OrgID(@JsonProperty("value") String value) {
        super(value);
    }

    @Override
    protected void checkFormat(String id) throws IdentityFormattedException {
        Asserts.isTrue(id.startsWith("org:"), () -> new IdentityFormattedException("OrgID 格式错误：%s".formatted(id)));
    }
}
