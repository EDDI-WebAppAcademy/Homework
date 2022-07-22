package kr.eddi.demo.controller.second;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping("/Homework2")
public class AvgController {

    @ResponseBody
    @GetMapping("")
    public String StudentsAvgScore(){
        log.info("StudentsAvgScore() 메소드 작동!");

        int [] students = new int[30];
        int totalScore = 0;
        for (int i = 0; i < 30; i++) {
            students[i] = ((int)(Math.random() * 40) + 61);
        }
        for (int i = 0; i < 30; i++) {
            totalScore += students[i];
        }
        int avg = totalScore / 30;

        return "학생들 30명의 평균 점수는 " + avg + "입니다.";
    }
}
