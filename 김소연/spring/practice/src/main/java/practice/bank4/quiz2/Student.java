package practice.bank4.quiz2;

import java.util.Scanner;

import static practice.bank4.quiz2.Score.getScore;

/*
 * 5. 학생 클래스를 만들어봅시다.
 * 6. 학생 클래스에 수학, 영어, 국어 점수를 입력 받도록 개조합니다.
 * 7. 학생 클래스의 평균을 계산해봅시다.
 * 9. 7번 문제에서 분산을 구해봅시다.
 * 10. 7번 문제에서 표준 편차를 구해봅시다.
 * */
class Student {
    public static void main(String[] args) {
        Score sc = new Score();
        getScore();
        System.out.println("평균: " + sc.avg());
        System.out.println("분산: " + sc.var());
        System.out.println("표준편차: " +sc.sd());
    }

}
