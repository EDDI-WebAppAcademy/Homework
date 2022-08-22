package kr.eddi.demo.entity.third;


import kr.eddi.demo.utility.basic.third.CustomRandom;
import lombok.*;

import java.util.Random;

@Getter
@Setter
@NoArgsConstructor
public class ClassRoom {
    private String roomName;
    private Student[] students;
    private Random random;
    private final int MIN = 10;
    private final int MAX = 30;

    /**
     * 필드에서 최소값과 최대값을 받아 10과 30사이의 랜덤한 숫자의 학생 기록 배열을 생성,
     * 각 인덱스에 새로운 학생 객체 요소를 넣는다.
     */
    public void makeRandomStudents() {
        int randomStudentsNum = CustomRandom.makeIntCustomRandom(MIN, MAX);
        students = new Student[randomStudentsNum];

        for (int i = 0; i < randomStudentsNum; i++) {
            students[i] = new Student();
        }
    }

    /**
     * 시험 진행 메서드
     */

    public void takeTest() {
        for (int i = 0; i < students.length; i++) {
            students[i].takeTest();
        }
    }

    /**
     * 임의의 최소값을 받아 시험을 진행하는 메서드
     * @param min 최소 점수
     */
    public void takeTest(int min) {
        for (int i = 0; i < students.length; i++) {
            students[i].takeTest(min);
        }
    }

    /**
     * 각 반 학생들 점수의 평균 계산
     * @return
     */
    public float calcMean() {
        float total = 0;
        for (int i = 0; i < students.length; i++) {
            total += students[i].score.getScore();
        }
        float mean = total / students.length;
        return mean;
    }
}
