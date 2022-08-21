package kr.eddi.demo.entity.basic.third;


import kr.eddi.demo.utility.basic.third.CustomRandom;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class ClassRoom {
    //멤버변수
    private String roomName; //위에 @Getter와 @Setter로 인해 SetroomName이랑 GetroomName은 자동으로 생긴상태.
    private Student[] students;
    private final int MIN = 10; //상수 사용(변하지 않는 값)
    private final int MAX = 30;

    //메서드임.
    public void makeRandomStudents() {
        int randomStudentsNum = CustomRandom.makeIntCustomRandom(MIN, MAX);

        students = new Student[randomStudentsNum];

        for (int i = 0; i < randomStudentsNum; i++) {
            students[i] = new Student();
        }
    }

    public void takeTest() {
        for (int i = 0; i < students.length; i++) {
            students[i].takeTest();
        }
    }

    public void takeTest(int min) {
        for (int i = 0; i < students.length; i++) {
            students[i].takeTest(min);
        }
    }

    public float calcMean() {
        float mean = 0;

        for (int i = 0; i < students.length; i++) {
            mean += students[i].score.getScore();
        }

        return mean / students.length;
    }
}
