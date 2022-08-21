package javaBasic.questionMenu;

import javaBasic.question.*;

import java.util.Scanner;

public class QuestionMenu {
    private static Q1RandomCode q1 = new Q1RandomCode();
    private static Q2FibonacciNumbers q2 = new Q2FibonacciNumbers();
    private static Q3Get25thNumber q3 = new Q3Get25thNumber();
    private static Q4Gugudan7th q4 = new Q4Gugudan7th();
    private static Q5PrintEvenNumber q5 = new Q5PrintEvenNumber();
    private static Q6MultiplesOf3 q6 = new Q6MultiplesOf3();
    private static Q7SumMultiplesOf4 q7 = new Q7SumMultiplesOf4();
    private static Q8SumMultiplesOfRandomNumber q8 = new Q8SumMultiplesOfRandomNumber();
    private static Q9 q9 = new Q9();
    private static Q10 q10 = new Q10();
    private static Scanner sc;

    public void questionMenu() {
        sc = new Scanner(System.in);

        while(true) {
            System.out.print("보고 싶은 문제 풀이 번호를 선택하세요. (range : 1 ~ 10 ) : ");
            int menuNum = sc.nextInt();

            switch (menuNum) {
                case 1 :
                    q1.q1Solve();
                    break;
                case 2 :
                    q2.get20thFiboNumber();
                    break;
                case 3 :
                    q3.q3Solve();
                    break;
                case 4 :
                    q4.q4Solve();
                    break;
                case 5 :
                    q5.q5Solve();
                    break;
                case 6 :
                    q6.q6Solve();
                    break;
                case 7 :
                    q7.q7Solve();
                    break;
                case 8 :
                    q8.q8Solve();
                    break;
                case 9 :
                    q9.q9Solve();
                    break;
                case 0 :
                    q10.q10Solve();
                    break;
                default:
                    System.out.println("다시 입력해주세요.");
                    break;
            }
        }

    }
}
