package cn.nuturbo.dubbo.extension;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.serialize.ObjectInput;
import org.apache.dubbo.common.serialize.ObjectOutput;
import org.apache.dubbo.common.serialize.Serialization;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by penghs at 2024/2/14 18:12
 */
public class JacksonSerialization implements Serialization {
    private static final byte JACKSON_SERIALIZATION_ID = 31;

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public byte getContentTypeId() {
        return JACKSON_SERIALIZATION_ID;
    }

    @Override
    public String getContentType() {
        return "text/json";
    }

    @Override
    public ObjectOutput serialize(URL url, OutputStream output) throws IOException {
        return new JacksonObjectOutput(objectMapper, output);
    }

    @Override
    public ObjectInput deserialize(URL url, InputStream input) throws IOException {
        return new JacksonObjectInput(objectMapper, input);
    }
}