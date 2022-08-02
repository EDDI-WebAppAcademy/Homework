package kr.eddi.demo.entity.six.dicegame;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Score {
    private int totalScore;

    public void addScore(int score) {
        totalScore += score;

        if(totalScore < 0) {
            totalScore = 0;
        }
    }
}
