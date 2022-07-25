package homework0722.First;

import java.util.Random;

//    1. 65 ~ 122 사이의 랜덤한 문자를 생성하도록 한다.
//    여기서 소문자나 대문자가 아니라면 다시 생성하도록 프로그램을 만들어보자

public class FirstQeustion {

    public static void main(String[] args) {
        Random random = new Random();
        while (true){
            //65 ~ 122 사이의 랜덤한 int 값 부여
            int num = random.nextInt(65,122);
            //int 값 출력
            // 90같거나 작고 97 보다 같거나 큰 경우 알파벳 문자열 이므로 출력 후 중지
            if (num <=90 || 97<= num ) {
                char ch = (char) num;
                System.out.println("문자 : " + ch);
                System.out.println("숫자 : " + num);
                break;
            }
            else {
                // 아스키코드 91 ~ 96 은 특수 문자
                // 다른 문자 출력 시 문구 출력 후 재실행
                char ch = (char) num;
                System.out.println("문자 : " + ch);
                System.out.println("숫자 : " + num);
                System.out.println("알파벳 대문자 혹은 소문자가 아니므로 다시 실행합니다.");
            }

        }
    }


}




