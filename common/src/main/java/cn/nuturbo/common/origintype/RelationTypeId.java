package cn.nuturbo.common.origintype;
import cn.nuturbo.common.utils.Asserts;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by penghs at 2023/11/21 15:39
 */
public class RelationTypeId extends Identity {

    @JsonCreator
    public RelationTypeId(@JsonProperty("value") String value) {
        super(value);
    }

    @Override
    protected void checkFormat(String id) throws IdentityFormattedException {
        Asserts.isTrue(id.startsWith("r:"), () -> new IdentityFormattedException("RelationTypeId 格式错误:%s".formatted(id)));
    }
}
