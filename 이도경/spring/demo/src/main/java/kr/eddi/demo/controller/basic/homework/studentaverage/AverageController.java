package kr.eddi.demo.controller.basic.homework.studentaverage;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Slf4j
@Controller
public class AverageController {

    @ResponseBody
    @GetMapping("/homework2")
    public String Average() {

        Random random = new Random();
        int[] score = new int[30];

        for (int i = 0; i<30; i++) {
            score[i] = (int)(Math.random()*41)+60;
        }
        int sum = 0;
        for (int i = 0; i<30; i++) {
            sum += score[i];
        }
        return "학생들의 평균 점수는 "+sum/30+"점 입니다.";
}
}