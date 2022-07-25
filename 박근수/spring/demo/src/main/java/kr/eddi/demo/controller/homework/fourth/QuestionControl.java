package kr.eddi.demo.controller.homework.fourth;

import kr.eddi.demo.entity.basic.fourth.Q1_ASCII;
import kr.eddi.demo.entity.basic.fourth.Q2_FIBONACCI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/fourth")

public class QuestionControl {
    @ResponseBody
    @GetMapping("/Q1")
    public char random() {
        log.info("랜덤한 문자를 생성");
        Q1_ASCII ascii = new Q1_ASCII();

        return ascii.RandomNum();
    }

    @ResponseBody
    @GetMapping("/Q1")
    public int fibonacci() {
        log.info("피보나치 수열 만들기");
        Q2_FIBONACCI fibonacci = new Q2_FIBONACCI();

        return
    }
}
