package kr.eddi.demo.controller.homework.third.questionBank2;

public class Q8 {
    // 1 ~ 100까지 숫자를 순회한다.
    // 2 ~ 10 사이의 랜덤한 숫자를 선택하고 이 숫자의 배수를 출력해보도록 한다.

    public static void main(String[] args) {
        final int MIN = 1;
        final int MAX = 100;
        final int RANMIN = 2;
        final int RANMAX = 10;

        int ranNum = Q1.randomNumber(RANMIN, RANMAX);
        System.out.println(ranNum + "의 배수를 출력합니다.");
        System.out.println(Q5.multipleLoop(ranNum, MIN, MAX));
    }
}
