package kr.eddi.demo.controller.homework.fourth;

import java.util.Random;

public class EighthQuestion {
    public static void main(String[] args) {

        Random random = new Random();
        int num = random.nextInt(2,10);
        int sum = 0;
        int max = 100;

        System.out.println("2 ~ 10 사이에 숫자가 배정됩니다.");
        System.out.println("숫자 " + num + "배정 완료.");

        for (int i = 1; i <= max; i++) {
            if (i % num == 0) {
                sum += i;
            }
        }
        System.out.println("1부터 100까지 " + num + "의 배수의 합은 " + sum + "입니다.");
    }
}
