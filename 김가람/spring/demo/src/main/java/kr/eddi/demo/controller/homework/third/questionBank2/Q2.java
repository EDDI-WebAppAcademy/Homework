package kr.eddi.demo.controller.homework.third.questionBank2;

import java.util.Scanner;

public class Q2 {
    // 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ... 일명 피보나치 수열의 20번째 항을 구하도록 프로그램 해보자!

    public static void main(String[] args) {
        System.out.println("피보나치 수열을 구합니다.");
        Scanner sc = new Scanner(System.in);
        System.out.print("항 입력: ");
        int index = sc.nextInt();

        int num1 = 1;
        int num2 = 1;
        int num3 = 0;

        if (index == 1) {
            num3 = num1;
        } else if (index == 2) {
            num3 = num2;
        } else {
            for (int i = 0; i < (index-2); i++) {
                num3 = num1 + num2;
                num1 = num2;
                num2 = num3;
            }
        }
        System.out.printf("피보나치 수열의 %d번째 항은 %d입니다.", index, num3);
    }
}
