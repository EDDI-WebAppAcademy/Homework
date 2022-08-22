package choijaemin.homework.utility.third;

import java.util.Random;

public class CustomRandom {

    public static int makeIntCustomNum(int min,int max){
        Random random = new Random();

        return random.nextInt(max - min) +min;
    }
}
