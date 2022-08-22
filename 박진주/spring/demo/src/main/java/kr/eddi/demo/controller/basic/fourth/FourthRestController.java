package kr.eddi.demo.controller.basic.fourth;

import kr.eddi.demo.entity.basic.fourth.NumberLoop;
import kr.eddi.demo.entity.basic.fourth.Series;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@Slf4j
@RestController
@RequestMapping("/fourth")

public class FourthRestController {

    private final int FIBONACCI = 1;     // Series의 seriesNum 대입
    private final int CUSTOM = 2;
    private final int EXAMPLE2_DATA = 20; // Series 의 length 대입
    private final int EXAMPLE3_DATA = 25;

    private final int PRINT = 3;
    private final int ADD = 7;
    private final int RANDOM = 8;
    private final int REFRESH_RANDOM_SUM = 16;
    private final int REFRESH_RANDOM_MOVEMENT = 32;
    private final int EVEN = 2;
    private final int THREE = 3;
    private final int FOUR = 4;
    private final int NOT_IMPORTANT = 7777;


    @GetMapping("/find-fibonacci-series")
    public String findFibonacciSeries() {
        log.info("피보나치 수열을 검색합니다.");

        // 인스턴스 생성과 클래스에서 그냥 메소드 import해서 쓰는 경우 차이점 (내 생각)
        // 인스턴스를 생성해서 데이터를 사용하는 경우는 인스턴스 가져오는 클래스의 생성자 등 실제 값을 비워두고
        // 다른 클래스에서 사용할때 각각 실제 해당하는 값을 넣어 결과 출력 가능한 것


        Series series = new Series(FIBONACCI, EXAMPLE2_DATA);
        return "피보나치 수열의 " + EXAMPLE2_DATA + "번째 항은 "
                + series.findSeriesNum();
    }

    @GetMapping("/find-custom-series")
    public String findCustomSeries() {
        log.info("커스텀 수열을 검색합니다.");

        Series series = new Series(CUSTOM, EXAMPLE3_DATA);
        return "커스텀 수열의 " + EXAMPLE3_DATA + "번째 항은 "
                + series.findSeriesNum();                    // 결과값 돌려주는 메소드
    }

    // 여기서 위 클래스 동작 방식이 궁금했던 부분! -> 수열계산 메소드가 어디서 동작되는 건지 ????
    // ★동작방식을 살펴보자★
    // GetMapping에서는 실제 피보나치나 커스텀 수열 돌리는 메소드를 호출하지 않음
    // 대신 인스턴스를 생성하고, 리턴값에 결과값 돌려주는 메소드가 있음
    //-> 그럼 메소드는 어디서 동작하는 것일까?! 사실 실제메소드가 동작되는 부분이 생성자에 들어가 있음!
    // 즉, 생성자에서 수열종류, 길이를 받고 수열 종류에 따라 해당 메소드 실행
    // 즉, 생성자이니까 인스턴스를 생성시 자동으로 해당 메소드 실행되는 것!! / 그러므로 결과값 돌려주는 메소드에서 데이터를 가질 수 있음


    @GetMapping("/find-even")
    public String findEven() {
        log.info("지정된 숫자에서 짝수를 찾습니다.");

        NumberLoop numberLoop = new NumberLoop(1, 100);

        return numberLoop.operateWithCondition(EVEN);        //operateWithCondition (int condition)에서 switch문으로 조건에 맞는 메소드 리턴해줌
    }

    @GetMapping("/find-three-times")
    public String findThreeTimes() {
        log.info("지정된 숫자에서 3의 배수를 찾습니다.");

        NumberLoop numberLoop = new NumberLoop(1, 100);

        return numberLoop.operateWithCondition(THREE);
    }

    @GetMapping("/find-four-times-sum")
    public String findFourTimes() {
        log.info("findFourTimes()");

        NumberLoop numberLoop = new NumberLoop(1, 100, ADD);

        return numberLoop.operateWithCondition(FOUR);
    }

    @GetMapping("/find-specific-random-times")
    public String findSpecificRandomTimes() {
        log.info("findSpecificRandomTimes()");

        NumberLoop numberLoop = new NumberLoop(1, 100, RANDOM);

        return numberLoop.operateWithCondition(NOT_IMPORTANT);
    }

    @GetMapping("/find-refresh-random-sum")
    public String findRefreshRandomSum() {
        log.info("findRefreshRandomSum()");

        NumberLoop numberLoop = new NumberLoop(1, 100, REFRESH_RANDOM_SUM);

        return numberLoop.operateWithCondition(NOT_IMPORTANT);
    }

    @GetMapping("/find-refresh-random-movement")
    public String findRefreshRandomMovement() {
        log.info("findRefreshRandomMovement()");

        NumberLoop numberLoop = new NumberLoop(1, 100, REFRESH_RANDOM_MOVEMENT);

        return numberLoop.operateWithCondition(NOT_IMPORTANT);
    }







}
