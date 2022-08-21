package dice.test.thirdExample.controller.studentScoreCalculation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentsAvgScoreViewController {

        StudentsScoreCalculation sc = new StudentsScoreCalculation();

    @ResponseBody
    @GetMapping("/homework2")
    public String studentsAverageScoreView() {

        String avgResult = sc.studentsScoreAverage();

        return avgResult;
    }
}