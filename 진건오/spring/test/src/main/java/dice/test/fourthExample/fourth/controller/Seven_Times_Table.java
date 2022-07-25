package dice.test.fourthExample.fourth.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class Seven_Times_Table {
    private static final int startNum = 7;
    private static String[] num = new String[10];

    @ResponseBody
    @GetMapping("/fourth-test")
    public static String[] doMultiplication_table() {
        log.info("구구단 7단 로직 실행");

        if (startNum == 7) {
            for (int i = 1; i < 10; i++) {
                 num[i] = String.format("%d * %d = %d ", startNum, i, startNum * i);
            }
        }

        return num;
    }
}
