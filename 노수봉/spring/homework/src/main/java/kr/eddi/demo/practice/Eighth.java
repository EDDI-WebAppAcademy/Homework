package kr.eddi.demo.practice;

import java.util.Random;

public class Eighth {

    public static void main(String[] args) {

        Random random = new Random();
        int num = random.nextInt(2,10);
        System.out.println(num + "의 배수는 :" );
        for (int i = 1; i <= 100; i++) {
            if (i % num == 0) {
                System.out.println(i);
            }
        }
    }
}
