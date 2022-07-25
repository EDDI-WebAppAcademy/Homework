package kr.eddi.demo.controller.homework.second;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Slf4j
@Controller
public class AvgControllerRevised {
    private int studentNum;
    private final int MIN = 60;
    private final int MAX = 100;

    @ResponseBody
    @GetMapping("/homework2")
    public String AvgScore() {

        studentNum = 30;
        int[] student = new int[studentNum];
        Random ran = new Random();

        for (int i = 0; i < student.length; i++) {
            student[i] = ran.nextInt(((MAX - MIN) + 1)) + MIN;
        }

        int sum = 0;
        for (int i = 0; i < student.length; i++) {
            sum += student[i];
        }

        int avg = sum / student.length;

        return "평균 점수는 " + avg + "점 입니다.";
    }
}
