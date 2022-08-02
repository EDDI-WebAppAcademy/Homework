package kr.eddi.demo.controller.homework.second;

public class StudentScore {

    public static int getScore() {

        int[] score = new int[30];
        int sum = 0;

        for (int i = 0; i < score.length; i++) {
            score[i] = (int) (Math.random() * 41) + 60;
            sum += score[i];

        }

        return sum;

    }
}