package lbk.homework.day0725.makeMethodwithClass.utility;

import java.util.Random;

public class RandomUtility {
    public int randomNumber(int max, int min) {
        return new Random().nextInt(max - min) + min;
    }
}
