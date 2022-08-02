package kr.eddi.demo.controller.homework.fourth;

public class SixthQuestion {
    public static void main(String[] args) {
        for (int i = 1; i < 101; i++) {
            if (i % 3 == 0) {
                System.out.println(i);
            }
        }
        System.out.println("1부터 100까지의 숫자 중 3의 배수만 출력해보자!");
    }
}
