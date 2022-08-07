package kr.eddi.demo.homeworkEntity.seventh;

import kr.eddi.demo.homeworkEntity.utility.basic.seventh.LottoNum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class LottoScore {
    private int totalScore;

    // (숫자1 + 숫자2 + 숫자3 + 숫자4) * 숫자5 ] / 숫자6
    public void ScoreCalculation(int lottoNum, int lottoSequence) {
        if( lottoSequence < 5 ) {
            totalScore += lottoNum;
        } else if (lottoSequence == 5) {
            totalScore *= lottoNum;
        } else {
            if(lottoNum == 0){                       //마지막 6번째 숫자가 0일 경우 그냥 totalScore = 0 만들기
                totalScore = 0;
            } else{
                totalScore /= lottoNum;
            }

        }
    }
}