package questionBank.practice2;

import java.util.Random;

public class First {

//    1. 65 ~ 122 사이의 랜덤한 문자를 생성하도록 한다.
//    여기서 소문자나 대문자가 아니라면 다시 생성하도록 프로그램을 만들어보자

    public static void main(String[] args) {
        Random random = new Random();
        while (true){
            int num = random.nextInt(65,122);
            System.out.println("num : " + num);
            if ((65 <= num && num <= 90)
                || (97 <= num && num <= 122)){
                char ch = (char)num;
                System.out.println("ch : " + ch);
                break;
            }else {
                System.out.println("알파벳 대문자 혹은 소문자가 아닙니다.");
                System.out.println();
            }
        }
    }
}
