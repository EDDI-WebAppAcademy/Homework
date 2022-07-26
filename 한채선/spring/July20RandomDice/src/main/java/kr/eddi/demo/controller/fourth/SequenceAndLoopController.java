package kr.eddi.demo.controller.fourth;


import kr.eddi.demo.utility.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/fourth")
public class SequenceAndLoopController {


    @GetMapping("/find-random-alphabet")
    public String findRandomAlphabet() {

        log.info("1번 문제");
        AscciiAlphabet ascciiAlphabet = new AscciiAlphabet();
        String randomAsciiText = "랜덤한 아스키 코드의 알파벳: " + ascciiAlphabet.randomAlphabet();
        return randomAsciiText;
    }



        /*  2.
            1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
            일명 피보나치 수열의 20번째 항을 구하도록 프로그램 해보자! (완료)
        */

    @GetMapping("/find-fibonacci-series")
    public String findFibonacciseries() {
        log.info("2번 문제 : 피보나치 수열");
        Sequence sequence = new Sequence();
        return String.valueOf(sequence.sequence(1,20));
    }

    @GetMapping("/find-custom-series")
    public String customSequence() {
        log.info("3번 문제: 커스텀된 수열");
        Sequence sequence = new Sequence();
        return (String) sequence.sequence(2, 25);
    }


    @GetMapping("/multiple-table-seven")
    public String multipleTableSeveon() {
        log.info("4번 문제: 구구단 7단");
        DisplayNumbers displayNumbers = new DisplayNumbers();
        String multiTableSeven = displayNumbers.multiTable(7, 9);
        return multiTableSeven;
    }



    @GetMapping("/find-even")
    public String findEven() {
        log.info("5번 문제: 짝수만 출력");
        DisplayNumbers displayNumbers = new DisplayNumbers();
        return displayNumbers.displayNums(1, 100, 2);

    }


    @GetMapping("/find-multiple-third")
    public String findMultipleThird(){
        log.info("6번 문제: 3의 배수만 출력");
        DisplayNumbers displayNumbers = new DisplayNumbers();
        String findMultipleThirdNumbers = displayNumbers.displayNums(1, 100, 3);
        return findMultipleThirdNumbers;
    }

    @GetMapping("/find-multiple-fourth")
    public String findMultipleFourth() {
        log.info("7번 문제: 4의 배수의 총합");
        TotalSum totalSum = new TotalSum();
        return String.valueOf(totalSum.multipleSum(1, 100, 4));
    }

    @GetMapping("/find-multiple-random")
    public String findMultipleRandom() {
        log.info("8번 문제: 랜덤한 숫자의 배수");
        DisplayNumbers displayNumbers = new DisplayNumbers();
        String findMultipleRandomNumbers =  displayNumbers.displayNums(1, 100, RandomNumber.randomNum(2, 10));
        return findMultipleRandomNumbers;
    }


    @GetMapping("/find-random-number-movement")
    public String findRamdomNumberMovement() {
        log.info("10번 문제: 랜덤한 수만큼 이동한 숫자들의 총합");
        TotalSum totalSum = new TotalSum();
        return String.valueOf(totalSum.moveNumbersSum(1, 100, RandomNumber.randomNum(2, 10)));
    }
}



