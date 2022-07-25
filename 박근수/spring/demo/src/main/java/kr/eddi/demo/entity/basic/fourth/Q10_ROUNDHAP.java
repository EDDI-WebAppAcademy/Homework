package kr.eddi.demo.entity.basic.fourth;

import java.util.Random;

public class Q10_ROUNDHAP {
    public static void main(String[] args) {
        int max = 100;
        int count = 1;
        int total = 0;

        while (true) {

            Random random = new Random();
            int sum = 0;
            int num = random.nextInt(2, 10);

            for (int i = 1; i <= max; i++) {
                if (i % num == 0) {
                    sum += i;
                }
            }
            System.out.println(num + "의 배수의 합은 " + sum + "입니다.");
        }
    }
}
