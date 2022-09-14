package fourth.question2.q1;

import java.util.Random;

public class RandomString {

    private static String randomString;

    //랜덤 문자 생성 메소드
    public static void randomStringGenerator(){

        Random random = new Random();

        //Random 클래스의 nextInt(숫자)는 0 이상 숫자 미만 랜덤정수 생성 메소드
        int num = random.nextInt(3);

        StringBuilder str = new StringBuilder();


        // (0,1) 중 랜덤 숫자 생성하여 num에 할당 후, num이 0이면 대문자 랜덤문자 생성, num이 1이면 소문자 랜덤문자 생성
        if (num == 0) {
            str.append(String.valueOf((char) ((int)(random.nextInt(26)) + 65)));
            randomString = str.toString();
            //randomString = String.valueOf((char) ((int)(random.nextInt(26)) + 65)); // 대문자 생성
        } else if(num == 1){
            str.append(String.valueOf((char) ((int)(random.nextInt(26)) + 97)));
            randomString = str.toString();
            //randomString = String.valueOf((char) ((int)(random.nextInt(26)) + 97)); // 소문자 생성
        } else {
            str.append(String.valueOf((char) ((int)(random.nextInt()))));
            randomString = str.toString();
        }
        System.out.println(randomString);

    }

    // 랜덤 문자 생성 결과값 대소문자 확인 메소드
    public static void randomStringCheck(){
        //charAt을 사용하여 첫번째 문자를 추출하고,
        //Character.isUpperCase()를 사용 대문자인지 Character.isLowerCase()를 사용 소문자인지 확인

        char ch = randomString.charAt(0);
        if (Character.isUpperCase(ch) || Character.isLowerCase(ch)) {
            System.out.println("정상적으로 랜덤문자가 생성되었습니다.");
        } else {
            System.out.println("랜덤문자가 정상 출력되지 않아 재생성합니다.");
            randomStringGenerator();
        }
    }


    public static void main(String[] args) {

        randomStringGenerator();
        randomStringCheck();

    }
}


//1. 65 ~ 122 사이의 랜덤한 문자를 생성하도록 한다.
//   여기서 소문자나 대문자가 아니라면 다시 생성하도록 프로그램을 만들어보자
//[출처] 문제 은행 [ 2 ] (에디로봇아카데미) | 작성자 링크쌤



//문자열 형 변환 메소드 종류- String.valueOf() 속성과 Object.toString() 두 가지 메서드가 존재
//보통 문자열로 형 변환 시 toString()을 자주 사용하는데, null값을 문자열로 형 변환 시 NullPointerException를 발생
//String.valueOf()를 사용하면 전달받은 파라미터가 null이 전달될 경우 문자열 "null"을 반환
