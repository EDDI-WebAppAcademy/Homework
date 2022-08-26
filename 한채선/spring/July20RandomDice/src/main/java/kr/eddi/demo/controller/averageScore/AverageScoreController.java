package kr.eddi.demo.controller.averageScore;


import kr.eddi.demo.vo.MainTextRun;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping("/homework2")

public class AverageScoreController {

    @ResponseBody
    @GetMapping("/average-score-main")
    public String averageScoreMain() {
        log.info("averageScoreMain() 작동 확인");

        MainTextRun mainTextRun = new MainTextRun();
        return mainTextRun.showTotalAndAverage();
    }

    /* 체크할 사항
       1. 클래스와 메소드를 기능별로 분류하였으니 적절하게 나뉘었는지 피드백이 필요
       2. (우선 해결됨!) 평균점수가 소수점 아래까지 나와야 하나 소수점 아래의 값이 사라지는 이슈
     */
}
