package kr.eddi.demo.entity.basic.fourth;

import java.util.Scanner;

public class Q4_GUGUDAN {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();

        int[] dan = new int[num];
        System.out.println("구구단을 출력해보자!");

        for (int i = 1; i < 10; i++) {
            System.out.println(num + " * " + i + " = " + (num * i));
        }
        System.out.println("구구단" + num + "단");
    }
}
