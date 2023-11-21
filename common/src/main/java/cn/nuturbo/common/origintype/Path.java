package cn.nuturbo.common.origintype;

import cn.nuturbo.common.utils.Asserts;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

/**
 * Created by penghs at 2023/11/21 18:17
 */
@Getter
public class Path {

    private final List<RelatedFieldID> segments;

    @JsonCreator
    public Path(@JsonProperty("segments") List<RelatedFieldID> segments) {
        this.segments = Asserts.notEmpty(segments, "segments of path can not be empty.");
    }
}
