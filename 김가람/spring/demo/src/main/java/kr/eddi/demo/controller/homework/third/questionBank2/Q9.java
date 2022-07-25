package kr.eddi.demo.controller.homework.third.questionBank2;

import java.util.ArrayList;

public class Q9 {
    // 1 ~ 100까지의 숫자를 순회한다.
    // 2 ~ 10 사이의 랜덤한 숫자를 선택하고 이 숫자의 배수를 출력한다.
    // 다음 루프에서 다시 랜덤 숫자를 선택하고 해당 숫자의 배수를 출력한다.
    // 그 다음 루프에서 다시 작업을 반복한다.
    // 끝까지 순회 했을때 출력된 숫자들의 합은 얼마인가 ?
    public static void main(String[] args) {
        final int MIN = 1;
        final int MAX = 100;
        final int RANMIN = 2;
        final int RANMAX = 10;

        ArrayList<Integer> multipleNum = new ArrayList<>();

        for (int i = RANMIN; i <= RANMAX; i++) {

            int ranNum = Q1.randomNumber(RANMIN, RANMAX);
            System.out.println(ranNum + "의 배수가 들어왔습니다.");

            for(int j = MIN; j <= MAX; j++) {
                if(i % ranNum == 0) {
                    multipleNum.add(j);
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < multipleNum.size(); i++) {
            sum += multipleNum.get(i);
        }

        System.out.println("배수의 총합은 " + sum + "입니다.");
    }
}
