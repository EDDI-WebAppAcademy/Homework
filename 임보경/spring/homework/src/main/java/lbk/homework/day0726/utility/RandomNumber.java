package cls.i.lecture.day0726.utility;

import java.util.Random;

public class RandomNumber {
    public int makeRandom(int max, int min) {
        return new Random().nextInt(max - min) + min;
    }
}
