package choijaemin.homework.utility.nineth;

import java.util.Random;

public class CustomRandomNum {
    public static int makeRandomCardNum(int max,int min){
        Random random = new Random();

        return random.nextInt(max - min) +min;
    }
}
