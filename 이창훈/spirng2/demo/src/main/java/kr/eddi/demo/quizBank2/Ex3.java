package kr.eddi.demo.quizBank2;

import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("수열의 n번째 수 : ");
        int inputNum = sc.nextInt();
        System.out.println(sequence(inputNum));
    }

    static int sequence(int inputNum) {
        if (inputNum == 1) {
            return 1;
        }
        if (inputNum == 2) {
            return 1;
        }
        if (inputNum == 3) {
            return 1;
        }

        return sequence(inputNum - 1) + sequence(inputNum - 3);
    }
}
