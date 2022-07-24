package dice.test.fourthExample.third.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class NumberRule {

    private static int[] numberRule = new int[26];

    public static int role() {

        numberRule[0] = 1;
        numberRule[1] = 1;
        numberRule[2] = 1;

        for (int i = 3; i < numberRule.length; i++) {
            numberRule[i] = numberRule[i - 1] + numberRule[i - 3];
        }

        log.info("특정 규칙이 부여된 숫자에 25번째 항을 구하는 로직 실행");
        return numberRule[25];
    }

    @ResponseBody
    @GetMapping("/third-test")
    public String numberRule() {
        return "25번째 항의 값: " + role();
    }
}
