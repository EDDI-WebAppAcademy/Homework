package kr.eddi.demo.controller.homework.third.questionBank2;

import java.util.Scanner;

public class Q4 {
    // 구구단 7단을 출력해보자!

    public static void main(String[] args) {
        System.out.println("===== 구구단 =====");
        Scanner sc = new Scanner(System.in);
        System.out.print("단 입력: ");
        int dan = sc.nextInt();

        for (int i = 1; i < 10; i++) {
            System.out.println(dan + " * " + i + " = " + dan * i);
        }
    }
}
