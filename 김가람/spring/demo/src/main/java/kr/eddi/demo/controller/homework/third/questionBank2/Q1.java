package kr.eddi.demo.controller.homework.third.questionBank2;

import java.util.Random;

public class Q1 {
    // 65 ~ 122 사이의 랜덤한 문자를 생성하도록 한다.
    // 여기서 소문자나 대문자가 아니라면 다시 생성하도록 프로그램을 만들어보자

    public static void main(String[] args) {

        final int MIN = 65;
        final int MAX = 122;

        while(true) {
            int ranNum = randomNumber(MIN, MAX);
            System.out.printf("%d ~ %d 사이의 임의의 숫자는 %d입니다.", MIN, MAX, ranNum);
            System.out.println();

            char ch = (char)ranNum;

            if(Character.isUpperCase(ch) || Character.isLowerCase(ch)) {
                System.out.println(ranNum + "을(를) 문자로 변환합니다! -> " + ch);
                break;
            } else {
                System.out.println("대문자도 소문자도 아닙니다! -> " + ch);
                System.out.println("랜덤 숫자 뽑기를 다시 진행합니다.");
                continue;
            }
        }
    }

    public static int randomNumber (int min, int max) {
        Random random = new Random();
        int ranNum = random.nextInt((max - min) + 1) + min;
        return ranNum;
    }
}
