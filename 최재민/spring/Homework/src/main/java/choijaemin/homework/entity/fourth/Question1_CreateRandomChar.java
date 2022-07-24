package choijaemin.homework.entity.fourth;

import java.util.Random;

public class Question1_CreateRandomChar {
    private final int MAX = 122;
    private final int MIN = 65;
    Random random = new Random();

    public char creatRanNum(){


        while (true){
            char CreatRanNum = (char)(random.nextInt(MAX - MIN) +MIN);
            if ( CreatRanNum >= 65 && CreatRanNum <= 90){
                return CreatRanNum;
            } else if (CreatRanNum >= 97 && CreatRanNum <= 122) {
                return CreatRanNum;
            } else {
                System.out.println("영문이 아닙니다 문자를 다시 추출합니다.");
                continue;
            }

        }

    }


}
