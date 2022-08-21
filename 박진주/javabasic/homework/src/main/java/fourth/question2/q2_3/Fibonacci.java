package fourth.question2.q2_3;

import java.util.Scanner;

public class Fibonacci {

    // 2번문제 - 피보나치 수열 계산 메소드
    public static void fibonacchiCalculator() {

        //피보나치 구할 항 입력 받기
        Scanner sc = new Scanner(System.in);
        System.out.println("피보나치 구하고 싶은 항을 입력하세요: ");
        int num = sc.nextInt();

        int[] array = new int[num+2];

        // 입력받은 num만큼 피보나치 수열 구하기
        array[0] = 1;
        array[1] = 1;
        for (int i = 0; i < num; i++) {
            array[i+2] += array[i] + array[i+1];
            System.out.println(array[i]);
        }
    }


    // 3번문제 - 수열 계산 메소드
    public static void SequenceCalculator() {

        //피보나치 구할 항 입력 받기
        Scanner sc = new Scanner(System.in);
        System.out.println("수열 구하고 싶은 항을 입력하세요: ");
        int num = sc.nextInt();

        int[] array = new int[num + 3];

        // 입력받은 num만큼 수열 구하기
        array[0] = 1;
        array[1] = 1;
        array[2] = 1;
        for (int i = 0; i < num; i++) {
            array[i+3] += array[i+2] + array[i];
            System.out.println(array[i]);
        }
    }


}

//2번 문제- 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ... 일명 피보나치 수열의 20번째 항을 구하도록 프로그램 해보자!
//[출처] 문제 은행 [ 2 ] (에디로봇아카데미) | 작성자 링크쌤


//3번 문제 - 1, 1, 1, 2, 3, 4, 6, 9, 13, 19, 28, 41, 60, 88, 129, ...
//   이와 같은 숫자의 규칙을 찾아 25번째 항을 구하도록 프로그램 해보자!
//[출처] 문제 은행 [ 2 ] (에디로봇아카데미) | 작성자 링크쌤

//Narayana's cows sequence: a(0) = a(1) = a(2) = 1; thereafter a(n) = a(n-1) + a(n-3)