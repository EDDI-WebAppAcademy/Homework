package kr.eddi.demo.homeworkEntity.fifith;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;


@Slf4j
public class RandomString {

    private  String randomString;

    //랜덤 문자 생성 메소드
    public String makeRandomString(){

        Random random = new Random();

        //Random 클래스의 nextInt(숫자)는 0 이상 숫자 미만 랜덤정수 생성 메소드
        int num = random.nextInt(3);

        StringBuilder str = new StringBuilder();

        if (num == 0) {
            str.append(String.valueOf((char) ((int)(random.nextInt(26)) + 65)));
            randomString = str.toString();

        } else if(num == 1){
            str.append(String.valueOf((char) ((int)(random.nextInt(26)) + 97)));
            randomString = str.toString();

        } else {
            str.append(String.valueOf((char) ((int)(random.nextInt()))));
            randomString = str.toString();
        }
        return randomString;
    }
    // (0,1) 중 랜덤 숫자 생성하여 num에 할당 후, num이 0이면 대문자 랜덤문자 생성, num이 1이면 소문자 랜덤문자 생성
    //randomString = String.valueOf((char) ((int)(random.nextInt(26)) + 65)); // 대문자 생성
    //randomString = String.valueOf((char) ((int)(random.nextInt(26)) + 97)); // 소문자 생성


    // 랜덤 문자 생성 결과값 대소문자 확인 메소드
    public String makeRandomStringCheck(){

        makeRandomString();
        char ch = randomString.charAt(0);
        if (Character.isUpperCase(ch) || Character.isLowerCase(ch)) {
            log.info("정상적으로 랜덤문자가 생성되었습니다.");
        } else {
            log.info("랜덤문자가 정상 출력되지 않아 재생성합니다.");
            makeRandomString();
        }
        return randomString;
    }

    //charAt을 사용하여 첫번째 문자를 추출하고,
    //Character.isUpperCase()를 사용 대문자인지 Character.isLowerCase()를 사용 소문자인지 확인
}
