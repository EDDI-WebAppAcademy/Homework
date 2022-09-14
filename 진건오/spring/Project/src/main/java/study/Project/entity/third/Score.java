package study.Project.entity.third;

import lombok.Getter;
import lombok.Setter;
import study.Project.utility.basic.third.CustomRandom;


@Getter
@Setter
public class Score {
    private int score; // 점수로직

    // 최대값 최소값 설정
    private final int MAX = 100;
    private final int MIN = 0;


    // 랜덤 로직을 실행하여 난수 발생
    public void makeRandomScore() {
        score = CustomRandom.makIntCustomRandom(MIN, MAX); // 0 ~ 100
    }

    //오버로딩
    public void makeRandomScore(int min) {
        score = CustomRandom.makIntCustomRandom(min, MAX); // min ~ 100
    }
}
