package kr.eddi.demo.utility.fourth;

import java.util.Random;

public class CustomRandom {
    public static int makeCustomRandom(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}
