package lbk.homework.day0727.secondDiceGame.utility;

import java.util.Random;

public class CustomRandom {
    public static int makeCustomRandom(int max, int min){
        return new Random().nextInt(max - min) + min;
    }
}
