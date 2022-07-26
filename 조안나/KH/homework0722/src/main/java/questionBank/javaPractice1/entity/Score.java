package questionBank.javaPractice1.entity;

import java.util.ArrayList;

public class Score {


    /**
     * 유저들의 점수가 담긴 ArrayList를 받았을 때 그 중 가장 큰 점수를 반환시켜주는 메서드
     * @param userNum 유저들의 점수가 담긴 int형 ArrayList
     * @return 가장 큰 점수 값을 반환
     */
    public static int winnerScoreFind(ArrayList<Integer> userNum){
        int max = 0;
        for (int i = 0; i < userNum.size(); i++) {
            if(userNum.get(i) >= max)
                max = userNum.get(i);
        }
        return max;
    }

}
