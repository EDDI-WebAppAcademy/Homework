package dice.test.controller.studentScoreCalculation;

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
}
