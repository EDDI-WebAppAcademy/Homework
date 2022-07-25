package kr.eddi.demo.controller.homework.Homework0722;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Scanner;


@Slf4j
@Controller
@RequestMapping("/Homework4")


public class Practice4 {


    // [문제은행 4-1] 이중배열 초기화 후 아무값 대입


    public void arry() {

        int[][] age = {
                {1, 2, 3},
                {4, 5, 6}

        };


   // [문제은행 4-2] 1번 문제에서 초기화한 배열 출력

        for (int i = 0; i < age.length; i++) {

            int[] inArr = age[i];

            for (int x = 0; x < inArr.length; x++) {

                System.out.println(inArr[x] + "");
            }
            System.out.println();
        }

    }

}


   // [문제은행 4-3] 고양이 클래스 만들기


class cat {
}


   // [문제은행 4-4] 1번 문제를 클래스화 하기


   // [문제은행 4-5] 학생클래스 만들기


class student {


    // [문제은행 4-6] 학생클래스에 수학,영어,국어 점수를 입력 받도록 만들기
    public void imputScore() {
        Scanner sc = new Scanner(System.in);

        String[] names = new String[3]; // 배열의 길이 설정
        int[] numbers = new int[3];

        // 배열의 길이
        int size = names.length;

        for (int i = 0; i < size; i++) {
            // 문자열 입력
            System.out.println("과목을 입력하세요");
            names[i] = sc.next();

            // 숫자형 입력
            System.out.println("점수를 입력하시오");
            numbers[i] = sc.nextInt();
        }

        for (int i = 0; i < size; i++) {
            System.out.println(i + "과목:" + names[i] + ", 점수:" + numbers[i]);
        }


    // [문제은행 4-7] 학생클래스의 평균 계산하기
        int sum = 0;
        double avg;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        avg = sum / numbers.length;
    // [문제은행 4-9] 7번 문제에서 분산 구하기

        double var;
        double dev = 0;
        double devSum = 0;

        for (int i = 0; i < numbers.length; i++) {
            dev = (numbers[i] - avg);
            devSum += Math.pow(dev, 2);

        }

        var = devSum / numbers.length;


    // [문제은행 4-10] 7번 문제에서 표준편차 구하기

        double std;

        std = Math.sqrt(var);


    }
}
    // [문제은행 4-8] 주사위 클래스 만들기


    class dice {
    }



