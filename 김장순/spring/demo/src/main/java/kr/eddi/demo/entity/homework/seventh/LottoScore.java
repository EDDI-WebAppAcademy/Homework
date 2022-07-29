package kr.eddi.demo.entity.homework.seventh;

import lombok.Getter;

import java.util.List;

@Getter
public class LottoScore {
    private int resultScore;
    private List<Integer> scoreList;

    public void addScore(int score1, int score2){
        scoreList.add(score1);
        scoreList.add(score2);
    }
}
