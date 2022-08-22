package kr.eddi.demo.homework.entity.seventh_fix;


import kr.eddi.demo.homework.utility.seventh_fix.LottoNum1;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class LottoScore1 {

    private static final int LOTTO_NUMBER_LENGTH = 6;
    private static int[] numbers= new int[LOTTO_NUMBER_LENGTH];

    private static int[] totalScore;

   //  (숫자1 + 숫자2 + 숫자3 + 숫자4) * 숫자5 ] / 숫자6
    public static void ScoreCalculation( List<LottoPlayer1> players) {
        totalScore = new int[players.size()];
        for (int i = 0; i < players.size(); i++) {


            LottoNum1 lottoScoreNum1 = players.get(i).getLottoNum1();          // 카드는 플레이어 i의 카드값
            for (int j = 0; j <LOTTO_NUMBER_LENGTH ; j++) {              // 플레이어 i가 가진 카드의 -> number 배열(6개 숫자) 추출
                 numbers[j] = lottoScoreNum1.getNumbers()[j];
            }


            if (numbers[5] == 0) {                              // 6번째 숫자가 0이면 나누기 0 못하므로 그냥 0점 처리
                totalScore[i]= 0;
            } else {                                                              // 그 외에는 점수 산정
                totalScore[i]=((numbers[0] + numbers[1] + numbers[2] + numbers[3]) *
                        numbers[4] / numbers[5]);
            }
        }


    }

    public static int[] getTotalScore() {
        return totalScore;
    }
}

