package kr.eddi.demo.controller.homework.third.questionBank2;

public class Q7 {
    //1 ~ 100까지 숫자중 4의 배수를 더한 결과를 출력해보자!

    public static void main(String[] args) {
        final int MIN = 1;
        final int MAX = 100;
        int loopNum = 4;
        int sum = 0;

        Q5.multipleLoop(loopNum, MIN, MAX);

        for (int i = MIN; i <= MAX; i++) {
            if (i % 4 == 0) {
                sum += i;
            }
        }
        System.out.println("4의 배수의 총합은 " + sum + "입니다.");
    }
}
