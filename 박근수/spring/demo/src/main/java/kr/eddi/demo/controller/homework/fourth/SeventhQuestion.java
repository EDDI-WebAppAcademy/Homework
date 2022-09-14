package kr.eddi.demo.controller.homework.fourth;

public class SeventhQuestion {
    public static void main(String[] args) {
        int sum = 0;

        for (int i = 1; i < 101; i++) {
            if (i % 4 == 0) {
                sum += i;
            }
        }
        System.out.println("1 ~ 100까지 숫자중 4의 배수를 더한 결과를 출력해보자!" + sum);
    }
}
