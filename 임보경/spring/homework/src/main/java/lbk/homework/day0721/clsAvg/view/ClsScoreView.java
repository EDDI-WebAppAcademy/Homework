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
    @GetMapping("/class-avg-view")
    public String acquireScore() {
        String SumScore = clsCon.calClsScore();
        String avgScore = clsCon.calClsAvgScore();
        return SumScore + "  " + avgScore;
    }

    /* 일단 결과값은 나오나 후에 확인해볼 것 */
    // 1. 우선 클래스를 나눠봤지만 패키지 view에 들어갈 내용인지 판단이 안섬.
    // 2. 새로고침하면 기존의 데이터가 dice와 달리 지워지지 않고 남은채로 새로운 결과값이 출력됨.
}
