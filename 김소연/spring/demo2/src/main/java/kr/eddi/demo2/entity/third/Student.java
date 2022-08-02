package kr.eddi.demo2.entity.third;

import kr.eddi.demo2.utility.basic.third.CustomRandom;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {
    private String name;
    private String major;
    private int age;

    final String[] names = {
            "가가가","나나나","다다다", "라라라","마마마","바바바",
            "사사사","아아아","자자자", "차차차"
    };
    final String[] majors = {
            "물리학","수학","화학", "영문학","즁어중문학","인공지능",
            "일어일문학","컴퓨터공학","전자공학", "반도체공학"
    };
    private final int MIN = 20;
    private final int MAX = 39;

    Score score;
    //이렇게 되면 학생이 점수를 알아야 한다는 단점이 생기긴해
    //재사용성..가독성의 문제
    //이걸 쓰는 메서드를 찾아야하잖아
    //코드의 생산성 저하
    //일단 ㄱㄱ


    //랜덤할당
    public Student(){
        score = new Score();
        name = names[CustomRandom.makeIntCustomRandom(0,10)];
        major = majors[CustomRandom.makeIntCustomRandom(0, 10)];
        age = CustomRandom.makeIntCustomRandom(MIN, MAX);
    }

    public void takeTest() {
        score.makeRandomScore();
    }

    public void takeTest(int min) {
        score.makeRandomScore(min);
    }
}
