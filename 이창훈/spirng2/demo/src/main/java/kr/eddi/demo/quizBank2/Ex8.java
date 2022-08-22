package kr.eddi.demo.quizBank2;

import java.util.Random;

public class Ex8 {
    public static void main(String[] args) {
        int ranMin = 2;
        int ranMax = 10;
        int min = 1;
        int max = 100;

        int ranNum = new Random().nextInt(ranMax - ranMin + 1) + ranMin;

        for (int i = min; i <= max/ranMin; i++) {
            if (ranNum * i <= max) {
                System.out.println(ranNum * i);
            }
        }
    }
}
