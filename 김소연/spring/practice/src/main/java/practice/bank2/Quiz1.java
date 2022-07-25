package practice.bank2;

import java.util.Random;

public class Quiz1 {
    /*
    * 65 ~ 122 사이의 랜덤한 문자를 생성하도록 한다.
    * 여기서 소문자나 대문자가 아니라면 다시 생성하도록 프로그램을 만들어보자
    */

    public static void main(String[] args) {

        int min = 65;
        int max = 122;

        while (true) {
            int ranNum = (int) (Math.random() * (max - min + 1) + min);
            if ((ranNum <= 90) || (97 <= ranNum)) {
                char ranChar = (char) ranNum;
                System.out.println("랜덤 문자 : " + ranChar);
                break;
            } else {
                char ranChar = (char) ranNum;
                System.out.println("랜덤 문자 : " + ranChar);
                System.out.println("소문자나 대문자가 아닙니다. 다시 생성합니다");
            }
        }
    }
}
