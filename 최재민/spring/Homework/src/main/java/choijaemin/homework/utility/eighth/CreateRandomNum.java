package choijaemin.homework.utility.eighth;

import java.util.Random;

public class CreateRandomNum {
    public static int CreateLottoNum(int max,int min){
        Random random = new Random();

        return random.nextInt(max - min ) + min;
    }
}
