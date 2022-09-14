package kr.eddi.demo.controller.homework;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Slf4j
@Controller

public class StudentExamAverage {
    @ResponseBody
    @GetMapping("/student-average-point")
    public String averagePoint() {


        int[] pointRan = new int[30];
        for (int i = 0; i < 30; i++) {
            pointRan[i] = (int) (Math.random() * (100 - 60 + 1)) + 60;
        }

        int pointSum = 0;

        for (int j = 0; j < 30; j++) {
            pointSum = pointSum + pointRan[j];
        }

        int averagePoint = pointSum / pointRan.length;

        return " 반 평균 점수는 averagePoint 입니다 ";
    }
}
