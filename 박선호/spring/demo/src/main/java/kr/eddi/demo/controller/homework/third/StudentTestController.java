package kr.eddi.demo.controller.homework.third;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Slf4j
@Controller
@RequestMapping("/homework/third")
public class StudentTestController {

    Random random = new Random();
    int[] student = new int[30];

    @ResponseBody
    @GetMapping("/student-average")
    public String studentController() {
        for (int i = 0; i < student.length; i++) {
            int score = random.nextInt(41) + 60;
            student[i] = score;
        }
        int studentAverage = average();

        return "학생 수: " + student.length + ", 평균 점수: " + studentAverage;
    }

    public int sum() {
        int sum = 0;
        for (int i = 0; i < student.length; i++) {
            sum += student[i];
        }
        return sum;
    }

    public int average() {
        int avg = 0;
        avg = sum()/student.length;
        return avg;
    }
}
