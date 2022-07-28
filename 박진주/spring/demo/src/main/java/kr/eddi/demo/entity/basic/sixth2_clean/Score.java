package kr.eddi.demo.entity.basic.sixth2_clean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

// 점수 클래스는 totalScore만 관리
public class Score {
    private int totalScore;

    public void addScore(int score) {
        totalScore += score;

        if (totalScore < 0) {
            totalScore = 0;
        }
    }
}