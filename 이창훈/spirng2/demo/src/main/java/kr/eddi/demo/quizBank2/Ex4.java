package kr.eddi.demo.quizBank2;

import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("원하는 단의 숫자를 눌러주세요 : ");
        int inputNum = sc.nextInt();
        System.out.println(inputNum + "단");
        for (int i = 1; i <= 9; i++) {
            System.out.println(inputNum + " x " + i + " = " + inputNum * i);
        }
    }
}
