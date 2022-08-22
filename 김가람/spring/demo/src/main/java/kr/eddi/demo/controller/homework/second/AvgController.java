package kr.eddi.demo.controller.homework.second;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Slf4j
@Controller
public class AvgController {

    @ResponseBody
    @GetMapping("/homework2")
    public String AvgScore() {

        int[] student = new int[30];
        Random ran = new Random();

        for (int i = 0; i < student.length; i++) {
            student[i] = ran.nextInt(60, 101);
        }

        int sum = 0;
        for (int i = 0; i < student.length; i++) {
            sum += student[i];
        }

        int avg = sum / student.length;

        return "평균 점수는 " + avg + "점 입니다.";
    }
}
