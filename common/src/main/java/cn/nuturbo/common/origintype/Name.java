package cn.nuturbo.common.origintype;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * Created by penghs at 2023/11/21 17:17
 */
@Getter
public class Name {

    private final String original;
    private final String prefix;
    private final String suffix;

    @JsonCreator
    public Name(@JsonProperty("original") String original, @JsonProperty("prefix") String prefix, @JsonProperty("suffix") String suffix) {
        this.original = original;
        this.prefix = prefix;
        this.suffix = suffix;
    }
}
