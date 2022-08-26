package kr.eddi.demo.practice;

import java.util.Random;

public class First {
    public static void main(String[] args) {
        Random random = new Random();
        while(true){
            int num = random.nextInt(65,122);
            char ch = (char)num;

            if (90 >= num || 97 <= num){
                System.out.println("숫자 : " + num);
                System.out.println("문자 : " + ch);
                break;
            }else{
                System.out.println("숫자 : " + num);
                System.out.println("문자 : " + ch);
                System.out.println("알파벳 대문자 또는 소문자가 아닙니다.");
            }

        }
    }
}
