package lbk.homework.day0727.secondDiceGame.entity;

import lombok.Getter;

@Getter
public class Score {
    private int totalScore;

    public void calScore(int score){

        totalScore += score;
        if(totalScore < 0) { totalScore = 0; }

    }
}
