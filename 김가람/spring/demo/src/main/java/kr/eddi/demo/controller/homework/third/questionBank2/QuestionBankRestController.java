package kr.eddi.demo.controller.homework.third.questionBank2;

import kr.eddi.demo.entity.homework.third.NumberToLetter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/homework3")
public class QuestionBankRestController {
    private int start = 65;
    private int end = 122;

    @GetMapping("/change-number-to-letter")
    public String changeNumberToLetter() {
        log.info("지정된 숫자를 문자로 변환하여 대소문자 확인하기.");

        NumberToLetter numberToLetter = new NumberToLetter(start, end);

        return numberToLetter.letterCheckLoop();
    }
}
