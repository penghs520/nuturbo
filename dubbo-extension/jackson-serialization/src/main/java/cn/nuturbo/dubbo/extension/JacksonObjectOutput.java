package cn.nuturbo.dubbo.extension;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.dubbo.common.serialize.ObjectOutput;

import java.io.*;

/**
 * Created by penghs at 2024/2/14 18:17
 */
public class JacksonObjectOutput implements ObjectOutput {

    private final ObjectMapper objectMapper;

    // private final PrintWriter writer;//TODO 性能测试、优化
    private final BufferedOutputStream os;

    private static final int BUFFER_SIZE = 256;//TODO 性能测试

    public JacksonObjectOutput(OutputStream output) {
        this(new ObjectMapper(), output);
    }

    public JacksonObjectOutput(ObjectMapper objectMapper, OutputStream out) {
        this.objectMapper = objectMapper;
        this.os = new BufferedOutputStream(out, BUFFER_SIZE);
    }

    @Override
    public void writeBool(boolean v) throws IOException {
        writeObject(v);
    }

    @Override
    public void writeByte(byte v) throws IOException {
        writeObject(v);
    }

    @Override
    public void writeShort(short v) throws IOException {
        writeObject(v);
    }

    @Override
    public void writeInt(int v) throws IOException {
        writeObject(v);
    }

    @Override
    public void writeLong(long v) throws IOException {
        writeObject(v);
    }

    @Override
    public void writeFloat(float v) throws IOException {
        writeObject(v);
    }

    @Override
    public void writeDouble(double v) throws IOException {
        writeObject(v);
    }

    @Override
    public void writeUTF(String v) throws IOException {
        writeObject(v);
    }

    @Override
    public void writeBytes(byte[] v) throws IOException {
        os.write(v);
    }

    @Override
    public void writeBytes(byte[] v, int off, int len) throws IOException {
        os.write(v, off, len);
    }

    @Override
    public void writeObject(Object obj) throws IOException {
        byte[] bytes = objectMapper.writeValueAsBytes(obj);
        os.write(bytes, 0, bytes.length);
        //os.flush();
    }

    @Override
    public void flushBuffer() throws IOException {
        os.flush();
    }
}

