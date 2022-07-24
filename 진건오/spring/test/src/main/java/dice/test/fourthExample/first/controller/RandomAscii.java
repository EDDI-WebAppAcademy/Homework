package dice.test.fourthExample.first.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Slf4j
@Controller
public class RandomAscii {
    private static int asciiNum;
    private static String asciiStr;
    private static Random random;

    // 아스키코드 랜덤 생성
    public static String doRandomAscii() {
        random = new Random();
        asciiNum = random.nextInt(122 - 92) + 92;

        asciiStr = Character.toString(asciiNum);
        log.info("생성 로직 실행 (1)");
        return asciiStr;
    }

    // 특수문자 아스키코드 재생성 로직
    // 이부분은 뭔가 엉성해서 포기
//    public static String doRandomAscii(int num) {
//        String newAscii;
//
//        String changeAscii = Character.toString(num);

//        try {
//            newAscii = changeAscii.replaceAll(changeAscii, doRandomAscii());
//        } catch (PatternSyntaxException e) {
//            newAscii = changeAscii.replaceAll("\\\\", doRandomAscii());
//            return newAscii;
//        }
//
//        log.info("대소문자가 아닌 아스키코드 재생성 로직 실행");
//        return newAscii;
//    }

    // 랜덤으로 생성된 아스키코드중 특수문자 검사 기능
    public static String checkAscii() {
        String returnStr = doRandomAscii();
        int returnNum = returnStr.charAt(0);

        if (65 <= returnNum || returnNum >= 122 ) {
            asciiStr = Character.toString(returnNum);
            if (91 <= returnNum && returnNum <= 96){
//                int wrongAscii = returnNum;
//                wrongRandomAscii();
//                return doRandomAscii(wrongAscii);
                return "특수문자가 생성됐습니다.";
            }
        }
        return asciiStr;
    }

    @ResponseBody
    @GetMapping("/first-test")
    public String createAscii() {
        return "생성된 아스키코드는 : " + checkAscii();
    }
}
