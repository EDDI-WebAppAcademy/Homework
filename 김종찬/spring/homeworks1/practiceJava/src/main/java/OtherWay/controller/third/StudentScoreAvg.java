package OtherWay.controller.third;

import kr.eddi.demo.entity.Averege;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller

public class StudentScoreAvg {


    Averege sc = new Averege();
    @ResponseBody
    @GetMapping("/homework2")
    public String studentsScoreResult() {

        String result = sc.averageCirculator();

        return result;
    }


}
