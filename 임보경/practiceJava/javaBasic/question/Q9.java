package javaBasic.question;

import javaBasic.utility.RandomUtil;

/*
* 9. 1 ~ 100까지의 숫자를 순회한다.
    2 ~ 10 사이의 랜덤한 숫자를 선택하고 이 숫자의 배수를 출력한다.
    다음 루프에서 다시 랜덤 숫자를 선택하고 해당 숫자의 배수를 출력한다.
    그 다음 루프에서 다시 작업을 반복한다.
    끝까지 순회 했을때 출력된 숫자들의 합은 얼마인가 ?
* */
public class Q9 {
    private static RandomUtil ru = new RandomUtil();
    private static final int MAX = 10;
    private static final int MIN = 2;
    public void q9Solve() {
        int sum = 0;
        int end = 100;
        int cnt = 1;

        while(true) {
            int selectNum = ru.randomNumber(MAX, MIN);
            int multiNumber = selectNum * 2;
            System.out.println(cnt++ +"번째 숫자 배수는 " + selectNum + " * 2 = " + multiNumber);
            sum += multiNumber;
            end -= multiNumber;

            System.out.println("현재 랜덤으로 선택된 숫자의 배수들의 합은 : " + sum);
            System.out.println("지금 나의 위치는 : " + (100 - end));
            System.out.println();

            if ((end - multiNumber) < 0) {
                System.out.println("최종 합산 : " + sum);
                break;
            }
        }
    }
    }
