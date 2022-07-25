package kr.eddi.demo.controller.homework.third.questionBank2;

import java.util.ArrayList;

public class Q5 {
    // 1 ~ 100까지 숫자중 짝수만 출력해보자.
    public static void main(String[] args) {
        final int MIN = 1;
        final int MAX = 100;
        int loopNum = 2;
        System.out.println(loopNum + "의 배수를 출력합니다.");
        multipleLoop(loopNum, MIN, MAX);
    }

    public static ArrayList<Integer> multipleLoop(int loopNum, int min, int max) {
        ArrayList<Integer> multipleNum = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            if (i % loopNum == 0) {
                multipleNum.add(i);
            }
        }
        return multipleNum;
    }
}
