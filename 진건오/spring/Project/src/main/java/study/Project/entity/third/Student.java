package study.Project.entity.third;

import lombok.Getter;
import lombok.Setter;
import study.Project.utility.basic.third.CustomRandom;

@Getter
@Setter
public class Student {

    //이름, 전공, 나이
    private String name;
    private String major;
    private int age;


    /*
    이름 초기화
    */
    private final String[] names = {
            "가가가", "나나나", "다다", "라라라",
            "마마", "바바", "사사", "아아", "자자", "차차"
    };

    /*
    전공 초기화
    */
    private final String[] majors = {
            "물리학", "수학", "화학", "영문학", "중어중문학",
            "일어일문학", "컴퓨터공학", "전자공학", "반도체공학", "인공지능"
    };

    /*
    최대값 최속값 초기화
    */
    private final int MIN = 20;
    private final int MAX = 39;

    /*
    Score 클래스 호출
    */
    Score score;

    /*
    학생 정보 랜덤으로 주입
    */
    public Student() {
        name = names[CustomRandom.makIntCustomRandom(0, 10)];
        major = majors[CustomRandom.makIntCustomRandom(0, 10)];
        age = CustomRandom.makIntCustomRandom(MIN, MAX);
    }

    /*
    시험 보는 로직
    */
    public void takeTest(int min) {
        score = new Score();
        score.makeRandomScore(min); // 최소값을 기준으로 점수 측정
    }

    public void takeTest() {
        score = new Score();
        score.makeRandomScore();
    }
}
