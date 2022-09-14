package kr.eddi.demo.controller.homework.homework2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping("/homework2")
public class CalAvg {

    @ResponseBody
    @GetMapping("")
    public String calPoints() {
        log.info("calPoints() 동작");
        int total = 0;

        RanNum ran = new RanNum();
        for (int i = 0; i < 30; i++) {
            total += ran.ranNum();
        }
        int avg = total / 30;
        return "반 학생 30명의 평균 점수는 : "+avg+"점이다";
    }
}
