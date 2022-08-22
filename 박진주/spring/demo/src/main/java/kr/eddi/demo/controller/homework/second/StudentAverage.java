package kr.eddi.demo.controller.homework.second;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping("/homework2")

public class StudentAverage {

    @ResponseBody
    @GetMapping()
    public String getAverage() {
        log.info("학생 점수 평균 구하기");

        int sum = StudentScore.getScore();
        int average = sum/30;


        return "시험점수 총합은 "+ sum +"점이고 평균은 "+ average +"점입니다.";


    }
}


//문제은행 8번의 4번 하기 -> homework - 컨트롤러/ 레스폰스바디 이용해서 해보기

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

/**
 *  int[] score = new int[30];
 *         int sum = 0;
 *
 *         for (int i = 0; i < score.length ; i++) {
 *             score[i] = (int)(Math.random()*41)+60;
 *             sum += score[i];
 *
 *         }
 *
 *         int average = sum/30;
 */