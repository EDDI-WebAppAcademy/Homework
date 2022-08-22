package kr.eddi.demo.controller.homework.homework5;

import kr.eddi.demo.entity.homework.fifth.NumberLoopHomework;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/homework5")
public class NumberLoopController {
    private final int START = 1;
    private final int END = 100;
    private final int TWO = 2;
    private final int THREE = 3;
    private final int FOUR = 4;


    @GetMapping("/simple-finder-two")
    public String showSimpleFinde2() {
        log.info("2의 배수 검색 시작");

        NumberLoopHomework loop = new NumberLoopHomework(START, END);

        return loop.simpleFinder(TWO);
    }

    @GetMapping("/simple-finder-three")
    public String showSimpleFinder3() {
        log.info("3의 배수 검색 시작");

        NumberLoopHomework loop = new NumberLoopHomework(START, END);

        return loop.simpleFinder(THREE);
    }

    @GetMapping("/simple-finder-four")
    public String showSimpleFinder4() {
        log.info("4의 배수 검색 시작");

        NumberLoopHomework loop = new NumberLoopHomework(START, END);

        return loop.simpleFinder(FOUR);
    }
}
