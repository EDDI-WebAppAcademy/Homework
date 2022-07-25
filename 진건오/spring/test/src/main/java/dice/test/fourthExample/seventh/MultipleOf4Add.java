package dice.test.fourthExample.seventh;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class MultipleOf4Add {

    private static int multipleOf4Sum;
    private static final int MAX = 100;

    public static int calcMultipleOf4Add() {
        log.info("1 ~ 100까지 4의 배수 합 구하는 로직 실행");
        for (int i = 1; i <= MAX; i++) {
            if (i % 4 == 0) {
                multipleOf4Sum += i;
            }
        }
    return multipleOf4Sum;
    }

    @ResponseBody
    @GetMapping("seventh-test")
    public int multipleOf4View() {
        log.info("구해진 합 DP하는 로직");

        return calcMultipleOf4Add();
    }

}


