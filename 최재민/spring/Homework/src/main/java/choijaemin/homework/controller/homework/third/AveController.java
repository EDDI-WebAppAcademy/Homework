package choijaemin.homework.controller.homework.third;

import choijaemin.homework.entity.third.Student;
import choijaemin.homework.entity.third.StudentInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping("/second")
public class AveController {

    @ResponseBody
    @GetMapping("/homework")
    public String CalculateAve(){
        log.info("학생들의 평균 구하기");
        Student student = new Student();

        return student.showSumAverage();
    }
}
