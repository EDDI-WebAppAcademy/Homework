package com.example.demo.controller.basic.second;

import com.example.demo.entity.basic.StudentScoreAve;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping("/second")
public class StudentAveController {

    @ResponseBody
    @GetMapping("/student")
    public String studentScore(){
        log.info("studentScore() 동작");

        StudentScoreAve ave = new StudentScoreAve();
        return String.format(ave.studentScoreAve());

    }
}
