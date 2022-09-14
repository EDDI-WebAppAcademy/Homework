package fourth.question2;
import java.util.Scanner;

import static fourth.question2.q1.RandomString.randomStringCheck;
import static fourth.question2.q1.RandomString.randomStringGenerator;
import static fourth.question2.q2_3.Fibonacci.*;
import static fourth.question2.q4.Gugudan.makeGugudan;
import static fourth.question2.q5_6_7.Multiple.CalcMultiple;
import static fourth.question2.q5_6_7.Multiple.CalcMultipleSum;
import static fourth.question2.q8_9_10.RandomNum.*;

public class CalculationSystem {
    public static void main(String[] args) {

        System.out.println("계산시스템에서 계산하고 싶은 항목의 숫자를 선택해주세요(1.랜덤문자생성, 2,수열생성 3. 배수출력 4. 랜덤숫자순회) 5. 구구단:");
        Scanner sc = new Scanner(System.in);
        int selection = sc.nextInt();

        if(selection == 1) {
            // 랜덤 문자 생성
            randomStringGenerator();
            randomStringCheck();

        } else if (selection == 2) {
            //수열
            fibonacchiCalculator();
            SequenceCalculator();
        } else if (selection == 3) {
            //배수 출력
            CalcMultiple(2);
            CalcMultiple(3);
            CalcMultipleSum(4);
        } else if(selection ==4) {
            //랜덤 넘버 순회
            MakeRandomNum();
            MakeRandomResult();
            MakeRandomResultLoop();
            MakeRandomResultSum();

        } else if (selection ==5) {
            //구구단 생성
            makeGugudan();
        } else {
            System.out.println("잘못 입력하셨습니다.해당하는 항목숫자를 다시 입력해주세요");
        }


    }
}
