package kr.eddi.homework.entity.seventh;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Score {
    //점수 총합
    //점수 조건 0
    private int totalScore;

    public void addScore(int score){
        totalScore += score;

        if(totalScore < 0){
            totalScore = 0;
        }
    }
}
