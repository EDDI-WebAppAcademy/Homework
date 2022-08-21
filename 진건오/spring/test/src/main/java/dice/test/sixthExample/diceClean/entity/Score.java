package dice.test.sixthExample.diceClean.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Score {
    private int totalScore;

    public void addScore(int score) {
        totalScore += score;

        if (totalScore < 0) {
            totalScore = 0;
        }
    }
}