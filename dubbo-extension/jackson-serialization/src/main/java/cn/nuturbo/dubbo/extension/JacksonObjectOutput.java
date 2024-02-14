package cn.nuturbo.dubbo.extension;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.dubbo.common.serialize.ObjectOutput;

import java.io.*;


public class JacksonObjectOutput implements ObjectOutput {

    private final ObjectMapper objectMapper;

    private final PrintWriter writer;

    public JacksonObjectOutput(OutputStream output) {
        this(new ObjectMapper(), output);
    }

    public JacksonObjectOutput(ObjectMapper objectMapper, OutputStream out) {
        this(objectMapper, new OutputStreamWriter(out));
    }

    public JacksonObjectOutput(ObjectMapper objectMapper, Writer writer) {
        this.objectMapper = objectMapper;
        this.writer = new PrintWriter(writer);
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
        writer.println(new String(v));
    }

    @Override
    public void writeBytes(byte[] v, int off, int len) throws IOException {
        writer.println(new String(v));
    }

    @Override
    public void writeObject(Object obj) throws IOException {
        writer.write(objectMapper.writeValueAsString(obj));
        writer.println();
        writer.flush();
    }

    @Override
    public void flushBuffer() throws IOException {
        writer.flush();
    }
}

