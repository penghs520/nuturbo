package cn.nuturbo.query.model.condition.value;

import cn.nuturbo.common.utils.Asserts;
import cn.nuturbo.query.model.condition.value.Value;
import lombok.Getter;

/**
 * Created by penghs at 2023/11/22 11:21
 */
@Getter
public non-sealed class KeywordValue implements Value {

    private final String keyword;

    public KeywordValue(String keyword) {
        this.keyword = Asserts.notNull(keyword, "value of KeywordValue can not be null");
    }
}
