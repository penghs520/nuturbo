package cn.nuturbo.common.origintype;

import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 2022/6/18 4:57 PM
 *
 * @author penghs
 **/
public class NanoID {
    public static final Random DEFAULT_NUMBER_GENERATOR = new SecureRandom();
    public static final char[] DEFAULT_ALPHABET = "01234567890123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    public static final int DEFAULT_SIZE = 16;

    private NanoID() {
    }

    public static String random() {
        return randomNanoId(ThreadLocalRandom.current());
    }

    private static String randomNanoId(Random random) {
        if (DEFAULT_SIZE <= 0) {
            throw new IllegalArgumentException("size must be greater than zero.");
        }
        if (DEFAULT_ALPHABET.length != 0 && DEFAULT_ALPHABET.length < 256) {
            int mask = (2 << (int) Math.floor(Math.log(DEFAULT_ALPHABET.length - 1) / Math.log(2.0))) - 1;
            int step = (int) Math.ceil(1.6 * (double) mask * (double) DEFAULT_SIZE / (double) DEFAULT_ALPHABET.length);
            StringBuilder sb = new StringBuilder();
            while (true) {
                byte[] bytes = new byte[step];
                random.nextBytes(bytes);
                for (int i = 0; i < step; ++i) {
                    int alphabetIndex = bytes[i] & mask;
                    if (alphabetIndex < DEFAULT_ALPHABET.length) {
                        sb.append(DEFAULT_ALPHABET[alphabetIndex]);
                        if (sb.length() == DEFAULT_SIZE) {
                            return sb.toString();
                        }
                    }
                }
            }
        } else {
            throw new IllegalArgumentException("alphabet must contain between 1 and 255 symbols.");
        }
    }

}
