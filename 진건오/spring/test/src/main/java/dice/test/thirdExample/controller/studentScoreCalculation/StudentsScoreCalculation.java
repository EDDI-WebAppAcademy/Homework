package dice.test.thirdExample.controller.studentScoreCalculation;

import java.util.Random;

public class StudentsScoreCalculation {

    int[] students = new int[30];
    int sum = 0;
    int avg = 0;

    StringBuilder sb = new StringBuilder();

    public String studentsScoreAverage() {

        for (int i = 0; i < students.length; i++) {
            students[i] = (int)((Math.random() * 39) + 61);
            sum += students[i];
        }

        avg = sum / students.length;
        sb.append(">>>").append(" 총 점수 : " + sum).
                append(" 평균 점수 : " + avg).append("<<<");

        return sb.toString();
    }

    // 한 클래스에서 너무 많은 기능을 사용하고 있음 SRP원칙 위배
    // 패키지의 구분이 안돼있어 클래스들의 기능을 구분하기 어려움
    // lombok을 이용하여 선언되어있는 변수를 엔티티로 나누고 싶어 시도는 해봤지만 아직 미숙함 감이 있어 포기하고 하나로 합쳐버림 (아쉬움)
    // 오늘 강사님꼐서 리뷰해주신 과제 코드와 비교해보았을 때 전반적으로 많이 미숙하고 부족함
    // 알고리즘에 대해 조금 더 공부를 하고 고민해야 할 듯
    // 가장 큰 이슈 프로그램을 실행했을 때 기존 데이터가 사라지지않고 새로운 데이터가 계속해서 중첩되며 나타남


    //문제은행 2번 전부 클래스 구현
    //문제 4번 구현현
    
}

