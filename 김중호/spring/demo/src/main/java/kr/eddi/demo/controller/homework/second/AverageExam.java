package kr.eddi.demo.controller.homework.second;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;



@Slf4j
@Controller


public class AverageExam {

    @ResponseBody
    @GetMapping("/homework2")
    public String pointAverage() {


        int sum = 0;

        int[] random = new int[30];
        for (int i = 0; i < 30; i++) {
            random[i] = (int) (Math.random() * (41)) + 60;
        }

        for (int j = 0; j < 30; j++) {
            sum = sum + random[j];
        }

        int average = sum / 30;

        return "평균 :" + average;
    }
}
