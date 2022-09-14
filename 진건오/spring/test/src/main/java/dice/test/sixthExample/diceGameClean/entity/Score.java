package dice.test.sixthExample.diceGameClean.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Score {
    private int totalScore;

    public void calcScore(int score) {
        totalScore += score;

        if (totalScore < 0) {
            totalScore = 0;
        }
    }
}
