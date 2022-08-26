package kr.eddi.demo2.entity.third;

import kr.eddi.demo2.utility.basic.third.CustomRandom;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
//@RequiredArgsConstructor
//생성자 만들어주는. 필요한것만쓰겠다
@NoArgsConstructor
public class ClassRoom {
    private String roomName;
    private Student[] students;
    private final int MIN = 10;
    private final int MAX = 30;

    public void makeRandomStudents(){
        //Score랑 같은 패턴? utility만들어서 줄여

        int randomStudentsNum = CustomRandom.makeIntCustomRandom(MIN,MAX);
        students = new Student[randomStudentsNum];

        for (int i = 0; i < randomStudentsNum; i++) {
            students[i] = new Student();
        }

    }

    public void takeTest(){
        for (int i = 0; i < students.length ; i++) {
            students[i].takeTest();
        }
    }

    //60점미만 오버로딩
    public void takeTest(int min){
        for (int i = 0; i < students.length ; i++) {
            students[i].takeTest(min);
        }
    }

    //평균계산
    public float clacMean(){
        float mean = 0;
        for (int i = 0; i < students.length; i++) {
            mean += students[i].score.getScore();
        }
        return mean / students.length;
    }
}
