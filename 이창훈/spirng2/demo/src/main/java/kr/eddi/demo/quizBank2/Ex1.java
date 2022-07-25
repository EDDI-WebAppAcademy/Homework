package kr.eddi.demo.quizBank2;

import java.util.Random;

public class Ex1 {
    public static void main(String[] args) {
        int min = 65;
        int max = 122;


        while (true) {
            int ranNum = new Random().nextInt(max - min + 1) + min;
            if (ranNum <= 90 || ranNum >= 97) {
                System.out.println((char)ranNum);
                break;
            } else {
                System.out.println("알파벳이 아닙니다.");
            }
        }
    }
}
