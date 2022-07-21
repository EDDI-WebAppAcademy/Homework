package kr.eddi.homework.controller.second;

import kr.eddi.homework.entity.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Array;
import java.util.Arrays;


@Slf4j
@Controller

public class AverageScoreController {
    @ResponseBody
    @GetMapping("/homework2")
    public String avgScore(){
        log.info("avgScore() 동작");

        int[]scoreList = new int[30];
        for (int i = 0; i < 30; i++) {
            scoreList[i] = (int)(Math.random() * 41) + 60;
        }
        int sum = 0;
        int avg = 0;

        for (int i = 0; i < 30; i++) {
            sum += scoreList[i];
        }

        avg = sum / 30;

        return "학생들의 점수 : " + Arrays.toString(scoreList) + " 학급평균 : " + avg;
    }
}
