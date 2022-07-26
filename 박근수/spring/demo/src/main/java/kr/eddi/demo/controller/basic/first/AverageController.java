package kr.eddi.demo.controller.basic.first;

import kr.eddi.demo.controller.homework.third.Average;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping("/homework2")
public class AverageController {
// 리턴값이 없고, 잘 모르겠습니다....
    @ResponseBody
    @GetMapping("/average-score-main")
    public String averageMain() {
        log.info("averageMain() 작동 확인");

        // 여기서 저 클래스를 사용하고 싶으면 뭘 해야할까요 ?
        // 아직 어제 강의 복습이 덜 되가지고
        // 평균을 구하는 메소드?

        Average avg = new Average();
        return avg.classAvg();
    }
}