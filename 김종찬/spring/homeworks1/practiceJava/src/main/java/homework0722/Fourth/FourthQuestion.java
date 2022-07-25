package homework0722.Fourth;
//    4. 구구단 7단을 출력해보자!

import java.util.Scanner;

public class FourthQuestion {



    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        int[] gugu = new int[N];

        System.out.println("구구단 " + N +"단");
        for (int i = 1; i <= 9; i++) {
            System.out.println(N + " * " + i +" = " + (N * i));
        }
    }
}