package kr.eddi.demo.entity.basic.sixth.dirty;

import kr.eddi.demo.utility.basic.third.CustomRandom;
import lombok.Getter;

@Getter
public class Dice {
    private int[] diceNum;
    private final int MIN = 1;
    private final int MAX = 6;
    private final int DEFAULT = 2;

    Score score;

    public void rollDice() {
        int sum = 0;

        for (int i = 0; i < DEFAULT; i++) {
            this.diceNum[i] = CustomRandom.makeIntCustomRandom(MIN, MAX);
            sum += this.diceNum[i];
        }
        score.setTotalScore(sum);
    }
}
