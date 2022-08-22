package kr.eddi.demo.quizBank2;

import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("피보나치 수열의 n번째 수 : ");
        int inputNum = sc.nextInt();

        System.out.println(fibonacci(inputNum));
    }

    static int fibonacci(int inputNum) {
        if (inputNum == 1) {
            return 1;
        }
        if (inputNum == 2) {
            return 1;
        }

        return fibonacci(inputNum - 1 ) + fibonacci(inputNum - 2);
    }
}
