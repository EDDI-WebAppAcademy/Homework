package javaBasic;

import java.util.Random;

/*
1. 65 ~ 122 사이의 랜덤한 문자를 생성하도록 한다.
   여기서 소문자나 대문자가 아니라면 다시 생성하도록 프로그램을 만들어보자
* */

public class Q1RandomCode {
    private static final int MIN = 65;
    private static final int MAX = 122;

    public static void main(String[] args) {

        while (true) {
            int ranNum = randomUtil();
            String regExp = "^[a-zA-Z]*$";
            String result = changeToString();
            if (result.matches(regExp)) {
                System.out.println(result);
                System.out.println("제대로 나왔습니다.");
                break;
            } else {
                System.out.println(result);
                System.out.println("아직 대소문자 알파벳이 나오지 않아서 다시 합니다!");
            }
        }
    }

    public static int randomUtil() {
        Random ran = new Random();
        return ran.nextInt(MAX - MIN) + MIN;
    }

    public static String changeToString() {
        int ranNum = randomUtil();
        char ch = (char)ranNum;
        return String.valueOf(ch);
    }

}





