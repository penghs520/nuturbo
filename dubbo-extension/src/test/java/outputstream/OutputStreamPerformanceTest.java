package outputstream;

import org.openjdk.jmh.annotations.*;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

/**
 * Created by penghs at 2024/2/14 18:45
 */
@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 3, time = 1)
@Measurement(iterations = 5, time = 5)
@Threads(4)
@Fork(1)
@State(value = Scope.Benchmark)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class OutputStreamPerformanceTest {


    public static byte[] generateBytes() {
        byte[] bytes = new byte[4096];
        for (int i = 0; i < 4096; i++) {
            bytes[i] = (byte) i;
        }
        return bytes;
    }

    @Benchmark
    public void performanceTestBufferedOutputStream() {
        try {
            byte[] bytes = generateBytes();
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(System.out);
            bufferedOutputStream.write(bytes);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Benchmark
    public void performanceTestBufferedOutputStreamWithSize1024() {
        try {
            byte[] bytes = generateBytes();
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(System.out, 1024);
            bufferedOutputStream.write(bytes);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Benchmark
    public void performanceTestBufferedOutputStreamWithSize128() {
        try {
            byte[] bytes = generateBytes();
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(System.out, 128);
            bufferedOutputStream.write(bytes);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Benchmark
    public void performanceTestBufferedOutputStreamWithSize256() {
        try {
            byte[] bytes = generateBytes();
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(System.out, 256);
            bufferedOutputStream.write(bytes);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Benchmark
    public void performanceTestWriter() {
        String str = new String(generateBytes());
        PrintWriter bufferedOutputStream = new PrintWriter(System.out);
        bufferedOutputStream.write(str);
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
    }
}

