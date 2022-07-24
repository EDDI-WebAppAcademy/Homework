package choijaemin.homework.utility.fourth;

import java.util.Random;

public class CustomRandomNum {

    public static int makeRandomNum(int min,int max){
        Random random = new Random();

        return random.nextInt(max - min) +min;
    }
}
