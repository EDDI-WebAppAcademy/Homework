package study.Project.entity.third;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import study.Project.utility.basic.third.CustomRandom;


@Getter
@Setter
@NoArgsConstructor
public class ClassRoom {

    //반이름
    private String roomName;
    private Student[] students; // 학생들

    //최소값 최대값 초기화
    private final int MIN = 10;
    private final int MAX = 30;


    // 난수로 학생수 조절
    public void makeRandomStudents() {
        int randomStudentsNum = CustomRandom.makIntCustomRandom(MIN, MAX);
        students = new Student[randomStudentsNum];

        for (int i = 0; i < randomStudentsNum; i++) {
            students[i] = new Student(); // 학생 정보 메서드가 실행되면서 배열안에 정보가 입력됨
        }
    }


    // 시험점수를 학생배열 index에 주입
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


    //평균값 로직
    public float calcMean() {

        float mean = 0;

        for (int i = 0; i < students.length; i++) {
            mean += students[i].score.getScore();
        }

        return mean / students.length;
    }


}
