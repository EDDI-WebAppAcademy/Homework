package org.example;

import org.example.utility.*;

public class Main {
    public static void main(String[] args) {

        /*  1.
            65 ~ 122 사이의 랜덤한 문자를 생성하도록 한다.
            여기서 소문자나 대문자가 아니라면 다시 생성하도록 프로그램을 만들어보자. (완료) */

        System.out.println("1번 문제");
        AscciiAlphabet ascciiAlphabet = new AscciiAlphabet();
        System.out.println("랜덤한 아스키 코드의 알파벳: " + ascciiAlphabet.randomAlphabet());
        System.out.println();


        /*  2.
            1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
            일명 피보나치 수열의 20번째 항을 구하도록 프로그램 해보자! (완료)
        */

        System.out.println("2번 문제 : 피보나치 수열");
        Sequence sequence = new Sequence();
        sequence.sequence(1, 20);
        System.out.println();




        /*  3.
            1, 1, 1, 2, 3, 4, 6, 9, 13, 19, 28, 41, 60, 88, 129, ...
            이와 같은 숫자의 규칙을 찾아 25번째 항을 구하도록 프로그램 해보자! (none)
         */
        System.out.println("3번 문제 : 커스텀된 수열");
        sequence.sequence(2, 25);
        System.out.println();



        // 4. 구구단 7단을 출력해보자! (완료)
        System.out.println("4번 문제: 구구단 7단");
        DisplayNumbers displayNumbers = new DisplayNumbers();
        displayNumbers.multiTable(7, 9);
        System.out.println();



        // 5. 1 ~ 100까지 숫자중 짝수만 출력해보자. (완료)
        System.out.println("5번 문제: 짝수만 출력");
        displayNumbers.displayNums(1, 100, 2);
        System.out.println();



        // 6. 1 ~ 100까지 숫자중 3의 배수만 출력해보자! (완료)
        System.out.println("6번 문제: 3의 배수만 출력");
        displayNumbers.displayNums(1, 100, 3);
        System.out.println();


        // 7. 1 ~ 100까지 숫자중 4의 배수를 더한 결과를 출력해보자! (완료)
        System.out.println("7번 문제: 4의 배수의 총합");
        TotalSum totalSum = new TotalSum();
        System.out.println(totalSum.multipleSum(1, 100, 4));
        System.out.println();



        /*  8.
            1 ~ 100까지 숫자를 순회한다.
            2 ~ 10 사이의 랜덤한 숫자를 선택하고 이 숫자의 배수를 출력해보도록 한다.
         */



        System.out.println("8번 문제: 랜덤한 숫자의 배수");
        displayNumbers.displayNums(1, 100, RandomNumber.randomNum(2, 10));
        System.out.println();



        /*  9.
            1 ~ 100까지의 숫자를 순회한다.
            2 ~ 10 사이의 랜덤한 숫자를 선택하고 이 숫자의 배수를 출력한다.
            다음 루프에서 다시 랜덤 숫자를 선택하고 해당 숫자의 배수를 출력한다.
            그 다음 루프에서 다시 작업을 반복한다.
            끝까지 순회 했을때 출력된 숫자들의 합은 얼마인가 ?
         */

        // 문제에 대한 설명이 더 필요




       /* System.out.println("9번 문제");
        displayNumbers.oneToHundred();
        displayNumbers.oneToHundred(RandomNumber.randomNum(2, 10));
        System.out.println();
        */



        /*  10. 1 ~ 100까지의 숫자를 순회한다.
            9번과 유사하게 2 ~ 10을 가지고 작업을 진행한다.
            다만 이번에는 배수를 찾는게 아니라 랜덤한 숫자가 나온만큼만 이동하고
            이동했을때 나온 숫자들의 합을 계산하도록 만들어보자! (완료)
        */

        System.out.println("10번 문제: 랜덤한 수만큼 이동한 숫자들의 총합");
        System.out.println(totalSum.moveNumbersSum(1, 100, RandomNumber.randomNum(2, 10)));
        System.out.println();

    }
}