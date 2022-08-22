package kr.eddi.demo.homework.utility.seventh;

import java.util.Random;

public class RandomNickname {

    private static String Nickname;

    private static int nameLength = 4;

    //랜덤 문자 생성 메소드
    public static String makeNickname() {

        Random random = new Random();

        //Random 클래스의 nextInt(숫자)는 0 이상 숫자 미만 랜덤정수 생성 메소드

        StringBuilder str = new StringBuilder();

        for (int i = 0; i < nameLength; i++) {

            int num = random.nextInt(2);
            // (0,1) 중 랜덤 숫자 생성하여 num에 할당 후, num이 0이면 대문자 랜덤문자 생성, num이 1이면 소문자 랜덤문자 생성
            if (num == 0) {
                str.append(String.valueOf((char) ((int) (random.nextInt(26)) + 65)));
                Nickname = str.toString();

            } else {
                str.append(String.valueOf((char) ((int) (random.nextInt(26)) + 97)));
                Nickname = str.toString();
            }

        }
        return Nickname;
    }
}