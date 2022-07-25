package kr.eddi.demo.entity.third;


import kr.eddi.demo.utility.basic.third.CustomRandom;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {

    private String name;
    private String major;
    private int age;
    Score score;

    private final String[] names = {
            "가가가", "나나나", "다다다", "라라라", "마마마",
            "바바바", "사사사", "아아아", "자자자", "차차차"
    };

    private final String[] majors = {
            "물리학", "수학", "화학", "영문학", "중어중문학",
            "일어일문학", "컴퓨터공학", "음악학", "미술사학", "국어국문학"
    };

    private final int MIN = 20;
    private final int MAX = 39;


    public Student() {
        this.score = new Score();
        this.name = names[CustomRandom.makeIntCustomRandom(0,10)];
        this.major = majors[CustomRandom.makeIntCustomRandom(0,10)];
        this.age = CustomRandom.makeIntCustomRandom(MIN, MAX);
    }


    /**
     * 최소값을 받아 시험을 실시
     * @param min
     */
    public void takeTest(int min) {
        score = new Score();
        score.makeRandomScore(min);
    }

    /**
     * 시험 실시
     */
    public void takeTest() {
        score = new Score();
        score.makeRandomScore();
    }
}
