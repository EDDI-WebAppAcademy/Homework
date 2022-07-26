package kr.eddi.homework.controller.fifth;

import kr.eddi.homework.entity.fifth.Gugudan;
import kr.eddi.homework.entity.fifth.NumberLoop;
import kr.eddi.homework.entity.fifth.RandomChar;
import kr.eddi.homework.entity.fifth.Series;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/homework5")
public class FifthRestController {
    private final int FIBONACCI = 1;
    private final int CUSTION_SERIES = 2;
    private final int EXAMPLE2_DATA = 20;
    private final int EXAMPLE3_DATA = 25;

    private final int EVEN = 2;
    private final int THREE = 3;
    private final int FOUR = 4;
    private final int ADD = 7;
    private final int RANDOM = 8;
    private final int REFRESH_RANDOM_SUM = 16;
    private final int REFRESH_RANDOM_MOVEMENT = 32;
    private final int NOT_IMPORTATNT = 7777;

    private final int SEVEN = 7;
    private static final int MIN_VALUE = 65;
    private static final int MAX_VALUE = 122;


    @GetMapping("/find-fibonacci-series")
    public String findFibonacciSeries() {
        log.info("피보나치 수열을 검색합니다.");

        Series series = new Series(FIBONACCI, EXAMPLE2_DATA);
        return "피보나치 수열의 " + EXAMPLE2_DATA + "번째 항은 "
                + series.findSeriesNum();
    }

    @GetMapping("/find-custom-series")
    public String findCustomSeries(){
        log.info("커스텀 수열을  검색합니다.");
        Series series = new Series(CUSTION_SERIES,EXAMPLE3_DATA);
        return "커스텀 수열의 "+ EXAMPLE3_DATA + "번째 항은 "
                + series.findSeriesNum();
    }

    @GetMapping("/find-even")
    public String findEven(){
        log.info("지정된 숫자에서 짝수를 찾습니다.");

        NumberLoop numberLoop = new NumberLoop(1, 100);

        return numberLoop.operateWithCondition(EVEN);
    }

    @GetMapping("/find-three-times")
    public String findThreeTimes(){
        log.info("지정된 숫자에서 3의 배수를 검색합니다.");

        NumberLoop numberLoop = new NumberLoop(1, 100);

        return numberLoop.operateWithCondition(THREE);
    }

    @GetMapping("/find-four-times-sum")
    public String findFourTimesSum(){
        log.info("지정된 숫자에서 4의 배수의 합을 검색합니다.");

        NumberLoop numberLoop = new NumberLoop(1, 100, ADD);

        return numberLoop.operateWithCondition(FOUR);
    }

    @GetMapping("/find-specific-random-times")
    public String findSpecificRandomTimes() {
        log.info("지정된 숫자에서 랜덤한 숫자의 배수를 검색합니다.");

        NumberLoop numberLoop = new NumberLoop(1, 100, RANDOM);

        return numberLoop.operateWithCondition(NOT_IMPORTATNT);
    }

    @GetMapping("/find-refresh-random-sum")
    public String findRefreshRandomSum() {
        log.info("findRefreshRandomSum()");

        NumberLoop numberLoop = new NumberLoop(1, 100, REFRESH_RANDOM_SUM);

        return numberLoop.operateWithCondition(NOT_IMPORTATNT);
    }

    @GetMapping("/find-refresh-random-movement")
    public String findRefreshRandomMovement() {
        log.info("findRefreshRandomMovement()");

        NumberLoop numberLoop = new NumberLoop(1, 100, REFRESH_RANDOM_MOVEMENT);

        return numberLoop.operateWithCondition(NOT_IMPORTATNT);
    }

    @GetMapping("/find-seventh-gugudan")
    public String findSeventhGugudan() {
        log.info("구구단을 검색합니다.");

        Gugudan gugudan = new Gugudan(SEVEN);
        return "====== " + SEVEN +"단 ======" + "<br>"
                + gugudan.makeGugudan();
    }

    @GetMapping("/find-random-eng-char")
    public String findRandomEngChar(){
        log.info("문자를 생성합니다.");

        RandomChar randomchar = new RandomChar(MIN_VALUE,MAX_VALUE);
        return randomchar.checkEngRandomChar();
    }
}
