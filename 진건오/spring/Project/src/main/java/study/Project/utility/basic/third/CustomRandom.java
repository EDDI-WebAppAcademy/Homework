package study.Project.utility.basic.third;

import java.util.Random;

// 랜덤로직
public class CustomRandom {
    public static int makIntCustomRandom(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
}
