package dice.test.fourthExample.second.controller;

import dice.test.fourthExample.second.entity.SequenceNumRule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class SequenceController {
    private static final int[] fibonacciValue = new int[21];
    private final int FIBONACCI_TOKEN = 1;
    private final int CUSTOMSEQUENCE_TOKEN = 2;

    private final int FIBONACCI_RANGE = 20;
    private final int CUSTOMSEQUENCE_RANGE = 25;

    @ResponseBody
    @GetMapping("/second-Fibonacci-test")
    public String FibonacciSequenceNum() {

        SequenceNumRule sequenceNumRule = new SequenceNumRule(FIBONACCI_TOKEN, FIBONACCI_RANGE);
        return "피보나치 수열의 " + FIBONACCI_RANGE + "번째 항은 " + sequenceNumRule.findByNum();
    }

    @ResponseBody
    @GetMapping("/second-Custom-test")
    public String customSequenceNum() {
        SequenceNumRule sequenceNumRule = new SequenceNumRule(CUSTOMSEQUENCE_TOKEN, CUSTOMSEQUENCE_RANGE);
        return "커스텀 수열의 " + FIBONACCI_RANGE + "번째 항은 " + sequenceNumRule.findByNum();
    }
}
