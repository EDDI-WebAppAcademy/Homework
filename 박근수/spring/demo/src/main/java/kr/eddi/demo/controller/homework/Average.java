package kr.eddi.demo.controller.homework;

public class Average {

    public String classAvg() {

        int[] score = new int[30];
        int sum = 0;

        for (int i = 0; i < score.length; i++) {
            score[i] = (int)(Math.random() * 40 + 60);
            if (score[i] >= 60) {
                sum += score[i];
            } else {
                i--;
                continue;
            }
        }
        int avg = sum / (score.length);

        return "평균 결과는 "+ avg +"입니다.";
    }
}
