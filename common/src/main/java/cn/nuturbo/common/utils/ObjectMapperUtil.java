package cn.nuturbo.common.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;

/**
 * Created by penghs at 2024/2/18 12:56
 */
public class ObjectMapperUtil {

    @Getter
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public <T> T readValue(String content, Class<T> valueType) {
        try {
            return objectMapper.readValue(content, valueType);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String writeValueAsString(Object value) {
        try {
            return objectMapper.writeValueAsString(value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
