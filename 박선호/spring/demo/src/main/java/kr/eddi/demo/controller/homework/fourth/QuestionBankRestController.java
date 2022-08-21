package kr.eddi.demo.controller.homework.fourth;

import kr.eddi.demo.entity.homework.fourth.Gugudan;
import kr.eddi.demo.entity.homework.fourth.LoopNumber;
import kr.eddi.demo.entity.homework.fourth.NumberChangeAscii;
import kr.eddi.demo.entity.homework.fourth.Sequence;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/fourth/homework")
public class QuestionBankRestController {

    private final int ASCII_START = 65;
    private final int ASCII_END = 122;
    private final int FIBONACCI = 1;
    private final int SUPER_GOLDEN = 2;
    private final int SEQUENCE1_LENGTH = 20;
    private final int SEQUENCE2_LENGTH = 25;

    @GetMapping("/random-ascii")
    public String randomAscii() {
        log.info("임의의 숫자를 소문자 및 대문자인 아스키 코드로 변환하여 나타냅니다.");

        NumberChangeAscii numberChangeAscii = new NumberChangeAscii(ASCII_START, ASCII_END);
        return "숫자를 아스키 코드로 변환한 문자는 " + numberChangeAscii.printRandomNumberChangeAscii() + "입니다.";
    }

    @GetMapping("/find-fibonacci-sequence")
    public String findFibonacciSequence() {
        log.info("피보나치 수열을 검색합니다.");

        Sequence sequence = new Sequence(FIBONACCI, SEQUENCE1_LENGTH);
        return "피보나치 수열의 " + SEQUENCE1_LENGTH + "번째 항의 값은 " + sequence.findSequenceNum() + "입니다.";
    }

    @GetMapping("/find-super-golden-sequence")
    public String findSuperGoldenSequence() {
        log.info("초황금비 수열을 검색합니다.");

        Sequence sequence = new Sequence(SUPER_GOLDEN, SEQUENCE2_LENGTH);
        return "초황금비 수열의 " + SEQUENCE2_LENGTH + "번째 항의 값은 " + sequence.findSequenceNum() + "입니다.";
    }

    @GetMapping("/gugudan")
    public String printGugudan() {
        log.info("구구단을 출력합니다.");

        Gugudan gugudan = new Gugudan(7);
        return gugudan.valueGugudan();
    }

    @GetMapping("/print-even")
    public String printEven() {
        log.info("지정된 숫자의 짝수를 출력합니다.");

        LoopNumber loopNumber = new LoopNumber(1, 100);
        return loopNumber.printMultipleOfNumber(2);
    }

    @GetMapping("/print-multiple-of-number")
    public String printMultipleOfNumber() {
        log.info("지정된 숫자의 배수를 출력합니다.");

        LoopNumber loopNumber = new LoopNumber(1, 100);
        return loopNumber.printMultipleOfNumber(3);
    }

    @GetMapping("/print-sum-multiple-of-number")
    public String printSumMultipleOfNumber() {
        log.info("지정된 숫자의 배수를 더하고 출력합니다.");

        LoopNumber loopNumber = new LoopNumber(1, 100);
        return loopNumber.printSumMultipleOfNumber(4);
    }

    @GetMapping("/print-multiple-of-random-number")
    public String printSumMultipleOfRandomNumber() {
        log.info("랜덤 숫자의 배수를 출력합니다.");

        LoopNumber loopNumber = new LoopNumber(1, 100);
        return loopNumber.printMultipleOfRandomNumber(2, 10);
    }

    @GetMapping("/print-sum-refresh-multiple-of-random-number")
    public String printSumRefreshMultipleOfRandomNumber() {
        log.info("printSumRefreshMultipleOfRandomNumber()");

        LoopNumber loopNumber = new LoopNumber(1, 100);
        return loopNumber.printSumRefreshMultipleOfRandomNumber(2, 10);
    }

    @GetMapping("/print-refresh-random-movement")
    public String printRefreshRandomMovement() {
        log.info("printRefreshRandomMovement()");

        LoopNumber loopNumber = new LoopNumber(1, 100);
        return loopNumber.printRefreshRandomMovement(2, 10);
    }
}
