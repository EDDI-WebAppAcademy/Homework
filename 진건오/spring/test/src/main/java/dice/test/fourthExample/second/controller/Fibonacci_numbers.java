package dice.test.fourthExample.second.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class Fibonacci_numbers {
    private static final int[] fibonacciValue = new int[21]; //


    public static int calcFiboNum() {

        fibonacciValue[1] = 1;
        fibonacciValue[2] = 1;

        for (int i = 3; i < fibonacciValue.length; i++) {
            fibonacciValue[i] = fibonacciValue[i - 1] + fibonacciValue[i - 2];
        }

        log.info("피보나치 수열 로직 실행");
        return fibonacciValue[20];


    }

    @ResponseBody
    @GetMapping("/second-test")
    public String fibonacciNum() {
        return "피보나치 수열 20번째 항: " + calcFiboNum();
    }

}
