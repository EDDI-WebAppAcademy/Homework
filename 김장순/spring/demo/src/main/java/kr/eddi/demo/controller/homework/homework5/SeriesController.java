package kr.eddi.demo.controller.homework.homework5;

import kr.eddi.demo.entity.homework.fifth.SeriesHomework;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/homework5")
public class SeriesController {
    private final int FIBO = 1;
    private final int CSTM = 2;
    private final int EX2N = 20;
    private final int EX3N = 25;

    @GetMapping("/find-fibonacci-series")
    public String findFibonacciSeries() {
        log.info("피보나치 수열을 검색합니다.");

        SeriesHomework series = new SeriesHomework(FIBO, EX2N);
        return "피보나치 수열의 " + EX2N + "번째 항은 "
                + series.findSeriesNum();
    }

    // 내가 여기서 뭘 하려고 하는가 ?
    //
    @GetMapping("/find-custom-series")
    public String findCustomSeries() {
        log.info("커스텀 수열을 검색합니다.");

        SeriesHomework series = new SeriesHomework(CSTM, EX3N);
        return "커스텀 수열의 " + EX3N + "번째 항은 "
                + series.findSeriesNum();
    }
}
