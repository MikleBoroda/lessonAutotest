package Lesson1;

import java.util.Random;

public class StringUtils {

    public static final String EN_STRING = "abcdeifghijklmnop";
    public static final Random RANDOM = new Random();

    public static String randomHexString(int length) {
        return randomString(EN_STRING, length);
    }

    public static String randomString(String pattern, int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int patternLength = pattern.length();
            int random = RANDOM.nextInt(patternLength);
            sb.append(random);
        }
        return sb.toString();
    }
}
