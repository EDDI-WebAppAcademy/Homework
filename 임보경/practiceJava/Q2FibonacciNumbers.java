package javaBasic;

/*2. 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ... 일명 피보나치 수열의 20번째 항을 구하도록 프로그램 해보자!*/
public class Q2FibonacciNumbers {

    static int[] fiboNumber = new int[20];

    public static void main(String[] args) {
        get20thFiboNumber();
    }

    public static void get20thFiboNumber() {
        fiboNumber[0] = 1;
        fiboNumber[1] = 1;

        for (int i = 2; i < fiboNumber.length; i++) {
            fiboNumber[i] = fiboNumber[i - 1] + fiboNumber[i - 2];
        }

        System.out.println(fiboNumber[19]);
    }


}


