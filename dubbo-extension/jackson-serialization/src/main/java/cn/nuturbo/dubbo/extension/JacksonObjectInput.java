package cn.nuturbo.dubbo.extension;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.apache.dubbo.common.serialize.ObjectInput;

import java.io.*;
import java.lang.reflect.Type;

/**
 * Created by penghs at 2024/2/14 18:18
 */
public class JacksonObjectInput implements ObjectInput {

    private final ObjectMapper objectMapper;

    private final BufferedReader reader;

    public JacksonObjectInput(InputStream input) {
        this(new ObjectMapper(), input);
    }

    public JacksonObjectInput(ObjectMapper objectMapper, InputStream input) {
        this(objectMapper, new InputStreamReader(input));
    }

    public JacksonObjectInput(ObjectMapper objectMapper, Reader reader) {
        this.objectMapper = objectMapper;
        this.reader = new BufferedReader(reader);
    }

    @Override
    public boolean readBool() throws IOException {
        return read(boolean.class);
    }

    @Override
    public byte readByte() throws IOException {
        return read(byte.class);
    }

    @Override
    public short readShort() throws IOException {
        return read(short.class);
    }

    @Override
    public int readInt() throws IOException {
        return read(int.class);
    }

    @Override
    public long readLong() throws IOException {
        return read(long.class);
    }

    @Override
    public float readFloat() throws IOException {
        return read(float.class);
    }

    @Override
    public double readDouble() throws IOException {
        return read(double.class);
    }

    @Override
    public String readUTF() throws IOException {
        return read(String.class);
    }

    @Override
    public byte[] readBytes() throws IOException {
        return readLine().getBytes();
    }

    @Override
    public Object readObject() throws IOException, ClassNotFoundException {
        return objectMapper.readTree(readLine());
    }

    @Override
    public <T> T readObject(Class<T> cls) throws IOException, ClassNotFoundException {
        return read(cls);
    }

    @Override
    public <T> T readObject(Class<T> cls, Type type) throws IOException, ClassNotFoundException {
        JavaType javaType = TypeFactory.defaultInstance().constructType(type);
        return objectMapper.readValue(readLine(), javaType);
    }

    private String readLine() throws IOException, EOFException {
        String line = reader.readLine();
        if (line == null || line.trim().length() == 0) {
            throw new EOFException();
        }
        return line;
    }

    private <T> T read(Class<T> cls) throws IOException {
        String json = readLine();
        return objectMapper.readValue(json, cls);
    }
}

