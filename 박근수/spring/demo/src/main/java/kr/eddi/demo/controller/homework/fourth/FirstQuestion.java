package kr.eddi.demo.controller.homework.fourth;

import java.util.Random;

public class FirstQuestion {
    private final int MIN = 65;
    private final int MAX = 122;
    Random random = new Random();
    public char RandomNum() {
        while (true) {
            char RandomNum = (char)(random.nextInt(MAX - MIN) + MIN);
            if (RandomNum >= 65 && RandomNum <= 90){
                return RandomNum;
            } else if (RandomNum >= 97 && RandomNum <= 122) {
                return RandomNum;
            } else {
                System.out.println("다시 생성합니다.");
                continue;
            }
        }
    }
}