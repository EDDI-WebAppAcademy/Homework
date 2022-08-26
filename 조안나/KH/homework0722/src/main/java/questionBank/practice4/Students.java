package questionBank.practice4;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.Scanner;

public class Students {
    static StudentsScore studentsAve = new StudentsScore();

    public static void main(String[] args) {
        subjectScore();
    }


    /**
     * 과목 점수를 입력하면 평균점수/분산/표준편차를 출력해주는 메서드
     */
    public static void subjectScore(){
        Scanner sc = new Scanner(System.in);
        System.out.print("수학 점수 : ");
        int mathScore = sc.nextInt();
        System.out.print("영어 점수 : ");
        int engScore = sc.nextInt();
        System.out.print("국어 점수 : ");
        int korScore = sc.nextInt();

        System.out.println();
        System.out.println("과목 평균 점수 : " +
                studentsAve.ave(mathScore, engScore, korScore));

        System.out.println("분산 : " +
                studentsAve.variance(mathScore, engScore, korScore));

        System.out.println("표준편차 : " +
                studentsAve.standardDeviation(mathScore, engScore, korScore));
    }
}
