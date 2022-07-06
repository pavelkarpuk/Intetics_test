package utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

public class RandomUtil {

    public static Integer randomInteger() {
        return RandomUtils.nextInt();
    }

    public static String randomString() {
        return RandomStringUtils.randomAlphanumeric(10);
    }
}
