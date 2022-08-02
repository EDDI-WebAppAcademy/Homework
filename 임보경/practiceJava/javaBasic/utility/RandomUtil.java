package javaBasic.utility;

import java.util.Random;

public class RandomUtil {
    public int randomNumber(int max, int min) {
        return new Random().nextInt(max - min) + min;
    }
}
