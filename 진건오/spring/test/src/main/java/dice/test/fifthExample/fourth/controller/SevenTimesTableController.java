package dice.test.fifthExample.fourth.controller;

import dice.test.fifthExample.fourth.entity.TimesTableProcess;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class SevenTimesTableController {

    private int timeTableNum;

    @ResponseBody
    @GetMapping("/times-table")
    public String printTimesTableNum() {
        timeTableNum = 5;
        TimesTableProcess timesTableProcess = new TimesTableProcess(timeTableNum);

        return timesTableProcess.findTimetableProcess(timeTableNum);
    }

}
