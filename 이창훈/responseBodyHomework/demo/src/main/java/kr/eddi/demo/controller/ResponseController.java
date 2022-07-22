package kr.eddi.demo.controller;

import kr.eddi.demo.entity.AvgScore;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Slf4j
@Controller
@RequestMapping("/response")
public class ResponseController {


    @ResponseBody
    @GetMapping("/homework2")
    public AvgScore averageScore() {
        log.info("averageScore() 동작");
        
        AvgScore avgScore = new AvgScore();

        
        int min = 60;
        int max = 100;
        int sum = 0;


        int[] score = new int[30];
        for (int i = 0; i < score.length; i++) {
            score[i] = new Random().nextInt(max - min + 1) + min;
        }
        for (int i = 0; i < score.length; i++) {
            sum += score[i];
        }
        
        double avg = (double) sum / score.length;

        avgScore.setAvg(avg);
        avgScore.setScore(score);
        avgScore.setSum(sum);
        return avgScore;
    }
}
