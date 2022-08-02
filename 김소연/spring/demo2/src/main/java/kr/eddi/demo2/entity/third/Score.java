package kr.eddi.demo2.entity.third;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
public class Score {
    private int score;
    private Random random;
    private final int Max = 100;

    public void makeRandomScore(){ //메서드이름 명확
        random = new Random();
        score = random.nextInt(Max);
    }

    //오버로딩
    public void makeRandomScore(int min){

        random = new Random();
        score = random.nextInt(Max-min) + min;
    }
    //오버로딩 통해 일관되게 처리함
}
