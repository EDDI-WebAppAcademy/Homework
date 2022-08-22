package kr.eddi.demo.practice;

public class Second {
    public static void main(String[] args) {
        int [] fibonacci = new int[20];

        fibonacci[0] = 1;
        fibonacci[1] = 1;

        for (int i = 2; i < fibonacci.length; i++) {
            fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
        }
        System.out.println("20번째 항의 값은 "+ fibonacci[19]);
    }
}
