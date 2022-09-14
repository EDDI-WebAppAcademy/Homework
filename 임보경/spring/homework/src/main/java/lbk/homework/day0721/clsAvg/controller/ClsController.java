package lbk.homework.day0721.clsAvg.controller;

import lombok.extern.slf4j.Slf4j;
import java.util.Random;

@Slf4j
public class ClsController {

    int[] clsArr = new int[30];
    int clsMember = clsArr.length;
    int sum = 0;

    StringBuilder testScore = new StringBuilder();

    public String calClsScore() {
        log.info("우리반 점수 계산");
        for (int i = 0; i < clsMember; i++) {
            clsArr[i] = new Random().nextInt(100 - 60) + 61;
            testScore.append(( i + 1 )+ "번 점수 ").append(clsArr[i]).append(", ");
        }

        return testScore.toString();
    }

    public String calClsAvgScore() {
        log.info("우리반 평균 점수 계산");
        for (int i : clsArr) {
            sum += i;
        }
        float avgScore = sum/clsMember;
        return String.format("우리반 평균 : %.1f" , avgScore);
    }
}
