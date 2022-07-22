package com.example.homework.second.controller;

import com.example.homework.second.entity.ClassAverage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class AverageController {

    @ResponseBody
    @GetMapping("/homework2")
    public String responseClassAverage() {
        log.info("responseClassAverage() 동작");

        ClassAverage classAvg = new ClassAverage();
        classAvg.randomScore();
        classAvg.calAvg();

        return "30명 반평균은 " + classAvg.getAverage() + "입니다.";
    }

}
