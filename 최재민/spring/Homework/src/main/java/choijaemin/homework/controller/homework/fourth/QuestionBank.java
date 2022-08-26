package choijaemin.homework.controller.homework.fourth;

import choijaemin.homework.entity.fourth.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Slf4j
@Controller
@RequestMapping("/fourth")
public class QuestionBank {

    @ResponseBody
    @GetMapping("/Question1")
    public char randomChar(){
        log.info("랜덤한 알파벳 만들기");
        Question1_CreateRandomChar RandomChar = new Question1_CreateRandomChar();

        return RandomChar.creatRanNum();
    }

    @ResponseBody
    @GetMapping("/Question2")
    public int fibonacci(){
        log.info("피보나치 수열 만들기");
        Question2_Fibonacci fibonacci = new Question2_Fibonacci();

        return fibonacci.fibonacciNum(); //실행결고 6765
    }

    @ResponseBody
    @GetMapping("/Question3")
    public int fibonacciApplication(){
        log.info("피보나치 수열 응용하기");
        Question3_Fibonacciapplication fibonacci = new Question3_Fibonacciapplication();

        return fibonacci.fibonacciApplication(); // 실행 결과 5896
    }

    @ResponseBody
    @GetMapping("/Question4")
    public String guguDan(){
        log.info("7단을 출력하기");
        Question4_Multiplication guguDan = new Question4_Multiplication();


        return guguDan.sevenDan();
        // 결과 [7X1=7, 7X2=14, 7X3=21, 7X4=28, 7X5=35, 7X6=42, 7X7=49, 7X8=56, 7X9=63]
    }

    @ResponseBody
    @GetMapping("/Question5")
    public String printEvenNumber(){
        log.info("1-100 사이 짝수 출력하기");
        Question5_PrintEvenMumber evenMumber = new Question5_PrintEvenMumber();

       return evenMumber.EvenNum();
        // 결과 [2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40,42,
        // 44,46,48,50,52,54,56,58,60,62,64,66,68,70,72,74,76,78,80,82,84,86,88,90,92,94,96,98,100]
    }

    @ResponseBody
    @GetMapping("/Question6")
    public String printThreeTimesNum(){
        log.info("1-100 사이 3의 배수 출력하기");
        Question6_PrintThreeTimesNum ThreeTimesNum = new Question6_PrintThreeTimesNum();

        return ThreeTimesNum.FindTimesNum();
        // 결과[3,6,9,12,15,18,21,24,27,30,33,36,39,42,45,48,51,54,57,60,63,66,69,72,75,78,81,84,87,90,93,96,99]
    }

    @ResponseBody
    @GetMapping("/Question7")
    public int sumFourTimesNum(){
        log.info("1-100 사이 4배수의 합 출력하기");
        Question7_SumFourTimesNum sumFourTimesNum = new Question7_SumFourTimesNum();

        return sumFourTimesNum.ShowFourTimesNum(); // 결과 1300
    }

    @ResponseBody
    @GetMapping("/Question8")
    public String printRanNumMultiple(){
        log.info("2-10사이 랜덤한 수의 배수 출력하기");
        Question8_PrintRanNumMultiple RanNumMultiple = new Question8_PrintRanNumMultiple();

        return RanNumMultiple.ranNumMultiple();
    }

    @ResponseBody
    @GetMapping("/Question9")
    public String RanNumLoopHundred(){
        log.info("2-10 사이의 배수를 100번 더하기");
        Question9_SumPrintNum SumtotalNum = new Question9_SumPrintNum();


        return SumtotalNum.showRanNumMultiple();
    }

    @ResponseBody
    @GetMapping("/Question10")
    public int sumRanNumLoopHundred(){
        log.info("2-10 랜던수만큼 이동하며 더하기");
        Question10_SumRanNumLoopHundred totalSum = new Question10_SumRanNumLoopHundred();

        return totalSum.showTotalSum();
    }
}
