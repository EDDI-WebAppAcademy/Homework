package kr.eddi.demo.entity.third;

import kr.eddi.demo.utility.basic.third.CustomRandom;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.util.pattern.PathPattern;

import java.util.ArrayList;
import java.util.Random;

@Getter
@Setter
public class Score {

    private int score;
    private Random random;
    private final int MIN = 0;
    private final int MAX = 100;

    /**
     * 학생들의 점수를 MAX 이하로 랜덤하게 생성
     */
    public void makeRandomScore() {
        score = CustomRandom.makeIntCustomRandom(MIN, MAX);
    }

    /**
     * 임의의 점수를 받아 그 이상의 점수를 랜덤하게 생성
     * @param min 임의의 최소 점수
     */

    public void makeRandomScore(int min) {
       score = CustomRandom.makeIntCustomRandom(min, MAX);
    }
}
