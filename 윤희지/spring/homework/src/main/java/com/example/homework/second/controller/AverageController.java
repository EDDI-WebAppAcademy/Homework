package com.example.homework.second.controller;

import com.example.homework.second.entity.ClassRoom;
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

        ClassRoom classAvg = new ClassRoom(30, 60);
        classAvg.makeStudent();
        classAvg.doExam();

        return classAvg.getStudentNum() + "명 반평균은 " + classAvg.calAvg() + "입니다.";
    }

}
