package kr.eddi.demo.controller.homework.third.questionBank2;

import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        // 1, 1, 1, 2, 3, 4, 6, 9, 13, 19, 28, 41, 60, 88, 129, ...
        // 이와 같은 숫자의 규칙을 찾아 25번째 항을 구하도록 프로그램 해보자!

        System.out.println("1, 1, 1, 2, 3, 4, 6, 9, 13, 19, 28, ... 규칙의 수열을 구합니다.");
        Scanner sc = new Scanner(System.in);
        System.out.print("항 입력: ");
        int index = sc.nextInt();

        int num1 = 1;
        int num2 = 1;
        int num3 = 1;
        int num4 = 0;

        if (index == 1) {
            num4 = num1;
        } else if (index == 2) {
            num4 = num2;
        } else if (index == 3) {
            num4 = num3;
        } else {
            for (int i = 0; i < (index-3); i++) {
                num4 = num1 + num3;
                num1 = num2;
                num2 = num3;
                num3 = num4;
            }
        }
        System.out.printf("해당 수열의 %d번째 항은 %d입니다.", index, num4);
    }
}
