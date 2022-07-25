package dice.test.fourthExample.third.entity;

import java.util.Random;

public class CreateRandom {
    private final int MAX;
    private final int MIN;
    private static Random random;

    public CreateRandom(int MAX, int MIN) {
        this.MAX = MAX;
        this.MIN = MIN;
    }

    public static int makeToCreateRandom(int MAX, int MIN) {
        random = new Random();
        int createNum = random.nextInt(MAX - MIN) + MIN;

        return createNum;
    }

    public static int remakeToCreateRandom(int MAX1, int MIN1, int MAX2, int MIN2) {
        random = new Random();
        int createNum = 0;

        if (MIN1 >= 97 && MAX1 <= 122) {
            createNum = random.nextInt(MAX1 - MIN1) + MIN1;
        } else if (MIN2 >= 65 && MAX2 <= 90) {
            createNum = random.nextInt(MAX2 - MIN2) + MIN2;
        }
        return createNum;
    }
}
