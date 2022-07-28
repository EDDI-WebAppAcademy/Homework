package kr.eddi.demo.entity.basic.sixth;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Score {
    private int totalScore;

    public void addScore(int Score){
        totalScore += Score;

        if(totalScore < 0){
            totalScore = 0;
        }
    }
}
