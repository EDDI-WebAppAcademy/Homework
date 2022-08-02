package questionBank.practice2;

import java.util.ArrayList;

public class Second {
//    2. 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
//    일명 피보나치 수열의 20번째 항을 구하도록 프로그램 해보자!

    private static final int INDEX = 20;

    public static void main(String[] args) {
    ArrayList<Integer> fibonacci = new ArrayList<>();
    int num1 = 0;
    int num2 = 1;
    int result = 0;

        for (int i = 1; i <= INDEX; i++) {
            fibonacci.add(result);
            System.out.println(i + "번째 result : " + result);
            result = num1 + num2;
            num1 = num2;
            num2 = result;
        }
        System.out.println();
        System.out.println(INDEX + "번째 피보나치 수열 : " + fibonacci.get(INDEX - 1));
    }
}
