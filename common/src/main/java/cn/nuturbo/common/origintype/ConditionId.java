package cn.nuturbo.common.origintype;

import cn.nuturbo.common.utils.Asserts;
import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Created by penghs at 2023/11/21 15:51
 */
public class ConditionId extends SubassemblyId {

    @JsonCreator
    public ConditionId(String value) {
        super(value);
    }

    @Override
    protected void checkFormat(String id) throws IdentityFormattedException {
        Asserts.isTrue(id.startsWith("filter:"), () -> new IdentityFormattedException("FilterId 格式错误: %s".formatted(id)));
    }
}
