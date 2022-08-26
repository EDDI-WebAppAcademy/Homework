package com.example.homework.javapractice.Controller;

import com.example.homework.javapractice.Entity.Gugudan;
import com.example.homework.javapractice.Entity.NumberLoop;
import com.example.homework.javapractice.Entity.RandomChar;
import com.example.homework.javapractice.Entity.Series;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/practice")
public class PracticeRestController {

    private final int GUGUDAN_NUM = 7;
    private final int FIBONACCI = 1;
    private final int CUSTOM = 2;
    private final int EXAMPLE2_DATA = 20;
    private final int EXAMPLE3_DATA = 25;
    private final int PRINT = 3;
    private final int ADD = 7;
    private final int RANDOM = 8;
    private final int REFRESH_RANDOM_SUM = 16;
    private final int REFRESH_RANDOM_MOVEMENT = 32;

    private final int EVEN = 2;
    private final int THREE = 3;
    private final int FOUR = 4;
    // operateWithCondition 메서드 동작의 일관성을 위해 추가한 듯.(random류의 메소드는 parameter가 굳이 필요하지 않아보임)
    private final int NOT_IMPORTANT = 7777;

    @GetMapping("/print-alphabet")
    public String printAlphabet() {
        log.info("알파벳을 출력합니다.");

        RandomChar randomAlpha = new RandomChar();
        return randomAlpha.findRandomAlphabet(NOT_IMPORTANT);
    }

    @GetMapping("/print-gugudan")
    public String printGugudan() {
        log.info("구구단을 출력합니다.");

        Gugudan gugu = new Gugudan(GUGUDAN_NUM);
        return gugu.makeGugudan(NOT_IMPORTANT);
    }

    @GetMapping("/find-fibonacci-series")
    public String findFibonacciSeries() {
        log.info("피보나치 수열을 검색합니다.");

        Series series = new Series(FIBONACCI, EXAMPLE2_DATA);
        return "피보나치 수열의 " + EXAMPLE2_DATA + "번째 항은 " + series.findSeriesNum();
    }

    @GetMapping("/find-custom-series")
    public String findCustomSeries() {
        log.info("커스텀 수열을 검색합니다.");

        Series series = new Series(CUSTOM, EXAMPLE3_DATA);
        return "커스텀 수열의 " + EXAMPLE2_DATA + "번째 항은 " + series.findSeriesNum();
    }

    @GetMapping("/find-even")
    public String findEven() {
        log.info("지정된 범위 내의 짝수를 검색합니다.");

        NumberLoop numberLoop = new NumberLoop(1, 100);
        return numberLoop.operateWithCondition(EVEN);
    }

    @GetMapping("/find-three-times")
    public String findThreeTimes() {
        log.info("지정된 범위 내의 3의 배수를 검색합니다.");

        NumberLoop numberLoop = new NumberLoop(1, 100);
        return numberLoop.operateWithCondition(THREE);
    }

    @GetMapping("/find-four-times-sum")
    public String findFourTimesSum() {
        log.info("지정된 범위 내의 4의 배수를 검색해 더합니다.");

        NumberLoop numberLoop = new NumberLoop(1, 100, ADD);
        return numberLoop.operateWithCondition(FOUR);
    }

    @GetMapping("/find-random-times")
    public String findRandomTimes() {
        log.info("지정된 범위 내의 특정 수의 배수를 검색합니다.");

        NumberLoop numberLoop = new NumberLoop(1, 100, RANDOM);
        return numberLoop.operateWithCondition(RANDOM);
    }

    @GetMapping("/find-refresh-random-sum")
    public String findRefreshRandomSum() {
        log.info("지정된 범위 내에서 무작위로 변경되는 특정 수의 배수를 검색하여 더합니다.");

        NumberLoop numberLoop = new NumberLoop(1, 100, REFRESH_RANDOM_SUM);
        return numberLoop.operateWithCondition(NOT_IMPORTANT);
    }

    @GetMapping("/find-refresh-random-movement")
    public String findRefreshRandomMovement() {
        log.info("지정된 범위 내에서 무작위로 나온 수만큼 이동하고 그 값들을 더합니다.");

        NumberLoop numberLoop = new NumberLoop(1, 100, REFRESH_RANDOM_MOVEMENT);
        return numberLoop.operateWithCondition(NOT_IMPORTANT);
    }
}
