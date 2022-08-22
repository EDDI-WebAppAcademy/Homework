package makeMethodwithClass.controller;

import makeMethodwithClass.entity.FindCode;
import makeMethodwithClass.entity.Loop;
import makeMethodwithClass.entity.Series;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/homework-day0725")
public class RestController {

    private final int FIBONACCI = 1;
    private final int CUSTOM = 2;



    @GetMapping("/bring-fibonacci-series")
    public int bringFibonacciSeries() {
        log.info("피보나치 수열을 가져옵니다.");
        Series series = new Series(20);
        series.divideSeries(FIBONACCI);
        return series.acquireSpecificNum();
    }

    @GetMapping("/bring-custom-series")
    public int bringCustomSeries() {
        log.info("커스텀 수열을 가져옵니다.");
        Series series = new Series(25);
        series.divideSeries(CUSTOM);
        return series.acquireSpecificNum();
    }

    @GetMapping("/bring-gugudan-seventh")
    public String bringGugudanSeventh() {
        log.info("7단 출력");
        Loop loop = new Loop(1, 69);

        return loop.findSpecificNumberTimes(7);
    }

    @GetMapping("/bring-even-number")
    public String bringEvenNumber() {
        log.info("1 ~ 100까지의 범위내에서 짝수들만 출력합니다.");
        Loop loop = new Loop(1, 100);

        return loop.findSpecificNumberTimes(2);
    }

    @GetMapping("/bring-three-times")
    public String bringThreeTimes() {
        log.info("1 ~ 100까지의 범위내에서 3의 배수만 출력합니다.");
        Loop loop = new Loop(1, 100);

        return loop.findSpecificNumberTimes(3);
    }

    @GetMapping("/bring-randomNumber-times")
    public String bringRandomNumberTimes() {
        log.info("1 ~ 100까지의 범위내에서 2 ~ 10까지의 숫자중 하나의 배수를 출력합니다.");
        Loop loop = new Loop(1, 100);

        return loop.findSpecificNumberTimes(loop.bringRandomNumber());
    }

    @GetMapping("/sum-four-times")
    public int sumFourTimes() {
        log.info("1 ~ 100까지의 범위내에서 4의 배수의 합");
        Loop loop = new Loop(1, 100);

        return loop.SumSpecificNumberTimes(4);
    }

    @GetMapping("/sum-multi-randomNumber")
    public int sumRandomNumberMulti() {
        log.info("매번 랜덤 숫자의 배수의 합을 구하기");
        Loop loop = new Loop(1, 100);

        return loop.SumMultiRandomNumber();
    }

    @GetMapping("/sum-random-number")
    public int SumRandomNumber() {
        log.info("매번 랜덤 숫자의 합을 구하기");
        Loop loop = new Loop(1, 100);

        return loop.SumMultiRandomNumber();
    }


    @GetMapping("/find-ascii-code")
    public String findAsciiCode() {
        log.info("랜덤으로 숫자를 굴려서 대소문자가 나오도록 해주세요.");
        FindCode findcode = new FindCode();

        return findcode.judgeCodeOrNot();
    }

}
