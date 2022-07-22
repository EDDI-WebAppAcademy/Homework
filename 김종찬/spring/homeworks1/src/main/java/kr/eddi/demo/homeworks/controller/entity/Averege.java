package kr.eddi.demo.homeworks.controller.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

@Getter
@Setter

// 위의 Getter, Setter가 실제 Lombok에서 제공하는 자동화 기능임.
// 클래스 내부의 변수들을 보고 알아서 Getter와 Setter를 만듦
// 그러나 경우에 따라 커스텀 메서드를 만들어야 할 수도 있으므로
// 실제로 매서드를 만드는 방법에 대해서는 잘 숙지하고 있어야함

public class Averege {

    int[] students = new int[30];
    int sum = 0;
    int avg = 0;

    StringBuilder sb = new StringBuilder();

    public String averageCirculator() {

        int[] score = new int[30];
        int sum = 0;

        for (int i = 0; i < score.length; i++) {
            score[i] = (int) (Math.random() * 41) + 60;
            sum += score[i];

        }

        sb.append(" 총 점수 : " + sum).append(" 평균 점수 : " + sum/30);

        return sb.toString();
    }
}