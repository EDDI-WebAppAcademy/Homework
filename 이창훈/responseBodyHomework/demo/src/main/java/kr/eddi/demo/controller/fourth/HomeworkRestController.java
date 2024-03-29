package kr.eddi.demo.controller.fourth;

import kr.eddi.demo.entity.fourth.NumberLoop;
import kr.eddi.demo.entity.fourth.Series;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/fourth")
public class HomeworkRestController {

    private final int FIBONACCI = 1;
    private final int CUSTOM = 2;
    private final int EXAMPLE2_DATA = 20;
    private final int EXAMPLE3_DATA = 15;

    private final int PRINT = 3;
    private final int ADD = 7;
    private final int RANDOM = 8;

    private final int EVEN = 2;
    private final int THREE = 3;
    private final int FOUR = 4;
    private final int FIVE = 5;
    private final int NOT_IMPORTANT = 7777;
    private final int MULTIPLY_NUMBER = 64;
    private final int SEVEN = 7;

    @GetMapping("/find-fibonacci-series")
    public String findFibonacciSeries() {
        log.info("피보나치 수열을 검색합니다.");
        Series series = new Series(FIBONACCI,EXAMPLE2_DATA);
        return "피보나치 수열의 " + EXAMPLE2_DATA + "번째 항은 " + series.findSeriesNum()  + " 입니다.";
    }

    @GetMapping("/find-custom-series")
    public String findCustomSeries() {
        log.info("커스텀 수열을 검색합니다.");
        Series series = new Series(CUSTOM,EXAMPLE3_DATA);
        return "커스텀 수열의 " + EXAMPLE3_DATA + "번째 항은 " + series.findSeriesNum()  + " 입니다.";
    }

    @GetMapping("/find-even")
    public String findEven() {
        log.info("지정된 숫자에서 짝수를 찾습니다.");
        NumberLoop numberLoop = new NumberLoop(1,100,PRINT);
        return numberLoop.operateWithCondition(EVEN);
    }

    @GetMapping("/find-three-times")
    public String findThreeTimes() {
        log.info("지정된 숫자에서 3의 배수를 찾습니다.");
        NumberLoop numberLoop = new NumberLoop(1,100,PRINT);
        return numberLoop.operateWithCondition(THREE);
    }

    @GetMapping("/find-four-times-sum")
    public String findFourTimesSum() {
        log.info("지정된 숫자에서 4의 배수를 찾아 모두 더합니다.");
        NumberLoop numberLoop = new NumberLoop(1,100,ADD);
        return numberLoop.operateWithCondition(FOUR);
    }

    @GetMapping("/find-five-times-sum")
    public String findFiveTimesSum() {
        log.info("지정된 숫자에서 5의 배수를 찾아 모두 더합니다.");
        NumberLoop numberLoop = new NumberLoop(1,100,ADD);
        return numberLoop.operateWithCondition(FIVE);
    }

    @GetMapping("/find-specific-random-times")
    public String findSpecificRandomTimes() {
        log.info("랜덤한 숫자의 배수를 찾습니다.");

        NumberLoop numberLoop = new NumberLoop(1, 100, RANDOM);

        return numberLoop.operateWithCondition(NOT_IMPORTANT);
    }

}
