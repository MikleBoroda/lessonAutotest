package at.study.redmine.utils;


import java.util.Random;

/**
 * Класс для работы со строками
 */

public class StringUtils {
    private static final String HEX_PATTERN = "0123456789abcdef";
    private static final String LATIN_PATTERN = "qazwsxedcrfvtgbyh";

    private final static Random RANDOM = new Random();

    public static String randomHexString(int length) {
        return randomString(HEX_PATTERN, length);

    }

    public static String randomEnglishString(int length) {
        return randomString(LATIN_PATTERN, length);
    }

    public static String randomEmail(){
        return randomEnglishString(6) + "@" + randomEnglishString(6) + "." + randomEnglishString(3);
    }

    public static String randomString(String pattern, int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int patternLength = pattern.length();
            int randomIndex = RANDOM.nextInt(patternLength);
            char c = pattern.charAt(randomIndex);
            sb.append(c);
        }
        return sb.toString();
    }
}
