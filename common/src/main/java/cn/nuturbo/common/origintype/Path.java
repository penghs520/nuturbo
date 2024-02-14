package cn.nuturbo.common.origintype;

import cn.nuturbo.common.utils.Asserts;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;

import java.io.IOException;
import java.util.List;

/**
 * Created by penghs at 2023/11/21 18:17
 */
@JsonSerialize(keyUsing = Path.Se.class)
@JsonDeserialize(keyUsing = Path.KeyDe.class)
public record Path(List<RelationFieldId> segments) {

    @JsonCreator
    public Path(@JsonProperty("segments") List<RelationFieldId> segments) {
        this.segments = Asserts.notEmpty(segments, "segments can not be empty.");
    }

    static class Se extends JsonSerializer<Path> {
        @Override
        public void serialize(Path value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            ObjectMapper objectMapper = (ObjectMapper) gen.getCodec();
            String key = objectMapper.writeValueAsString(value);
            gen.writeFieldName(key);
        }
    }

    static class KeyDe extends KeyDeserializer {
        @Override
        public Object deserializeKey(String key, DeserializationContext ctxt) throws IOException {
            ObjectMapper objectMapper = (ObjectMapper) ctxt.getParser().getCodec();
            return objectMapper.readValue(key, Path.class);
        }
    }
}
