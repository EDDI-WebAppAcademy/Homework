package kr.eddi.demo.entity.basic.practice7_26;

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
            totalScore = 0; //플레이어의 점수가 0점미만이 되면 0점으로 처리함.
        }
    }
}
