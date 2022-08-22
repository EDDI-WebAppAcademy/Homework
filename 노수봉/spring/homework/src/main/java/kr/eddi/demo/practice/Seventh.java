package kr.eddi.demo.practice;

public class Seventh {
    public static void main(String[] args) {

        int sum = 0;

        System.out.println("1부터 100까지의 숫자 중 4의 배수를 더한 값을 출력해보자!");
        for (int i = 1; i <= 100; i++) {
            if (i % 4 == 0) {
                sum = sum + i;
            }
        }
        System.out.println("더한 값 : " + sum);
    }
}
