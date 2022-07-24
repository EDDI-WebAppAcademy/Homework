package lbk.homework.day0721.clsAvg.view;

import lbk.homework.day0721.clsAvg.controller.ClsController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class ClsScoreView {
    private ClsController clsCon;

    public ClsScoreView() {
        clsCon = new ClsController();
    }

    @ResponseBody
    @GetMapping("/homework2")
    public String acquireScore() {
        String SumScore = clsCon.calClsScore();
        String avgScore = clsCon.calClsAvgScore();
        return SumScore + "  " + avgScore;
    }
}
