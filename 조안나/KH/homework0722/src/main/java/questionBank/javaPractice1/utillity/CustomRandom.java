package questionBank.javaPractice1.utillity;

import java.util.Random;

public class CustomRandom {

    /**
     * 최솟값과 최댓값 사이의 임의의 수를 반환 하는 메서드
     * @return MIN ~ MAX 사이의 임의의 수
     */
    public static int customRandom(int MIN, int MAX){
        Random randomDiceNum = new Random();
        return randomDiceNum.nextInt(MIN,MAX+1);
    }
}
