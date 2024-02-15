package outputstream;

import org.junit.jupiter.api.Test;

import java.io.BufferedOutputStream;
import java.io.IOException;

/**
 * Created by penghs at 2024/2/14 18:38
 */
public class OutputStreamTest {

    //生成一个4096字节的byte数组
    public static byte[] generateBytes() {
        byte[] bytes = new byte[4096];
        for (int i = 0; i < 4096; i++) {
            bytes[i] = (byte) i;
        }
        return bytes;
    }

    @Test
    public void testBufferedOutputStream() {
        byte[] bytes = generateBytes();
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(System.out);
            bufferedOutputStream.write(bytes);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
