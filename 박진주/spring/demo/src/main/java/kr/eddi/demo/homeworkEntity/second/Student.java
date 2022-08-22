package kr.eddi.demo.homeworkEntity.second;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {
    private int[] score = new int[30];
    private int sum;
    private int average;

//    public static void main(String[] args) {
//        int[] score = new int[30];
//        int sum = 0;
//
//        for (int i = 0; i < score.length ; i++) {
//            score[i] = (int) (Math.random()*100)+40;
//            sum += score[i];
//        }
//
//        int average = sum/30;
//    }

}


/**
 * 4. 반 학생이 30명이 있다.
 *
 *    이들은 모두 시험을 치뤘고 모든 학생들은 60점 미만이 없다고 한다.
 *
 *    이 상태에서 학생들의 점수를 임의로 배치하고
 *
 *    학급의 평균값을 구해보도록 한다.
 * [출처] 문제 은행 [ 3 ] (에디로봇아카데미) | 작성자 링크쌤
 */