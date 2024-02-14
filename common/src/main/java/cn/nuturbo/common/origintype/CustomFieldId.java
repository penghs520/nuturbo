package cn.nuturbo.common.origintype;

import cn.nuturbo.common.utils.Asserts;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;

/**
 * Created by penghs at 2023/11/22 19:01
 */
@JsonSerialize(keyUsing = CustomFieldId.Se.class)
@JsonDeserialize(keyUsing = CustomFieldId.KeyDe.class)
public final class CustomFieldId extends SchemaId implements FieldId {

    //for se/de
    private CustomFieldId() {

    }

    public CustomFieldId(String value) {
        super(value);
    }

    @Override
    public SchemaType schemaType() {
        return SchemaType.CustomField;
    }

    @Override
    protected void checkFormat(String id) throws IdentityFormattedException {
        Asserts.isTrue(id.startsWith("fd:"), () -> new IdentityFormattedException("CustomFieldId 格式错误: %s".formatted(id)));
    }


    static class Se extends JsonSerializer<CustomFieldId> {
        @Override
        public void serialize(CustomFieldId value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            ObjectMapper objectMapper = (ObjectMapper) gen.getCodec();
            String key = objectMapper.writeValueAsString(value);
            gen.writeFieldName(key);
        }
    }

    static class KeyDe extends KeyDeserializer {
        @Override
        public Object deserializeKey(String key, DeserializationContext ctxt) throws IOException {
            ObjectMapper objectMapper = (ObjectMapper) ctxt.getParser().getCodec();
            return objectMapper.readValue(key, CustomFieldId.class);
        }
    }
}
