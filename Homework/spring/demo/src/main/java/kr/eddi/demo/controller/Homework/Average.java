package kr.eddi.demo.controller.Homework;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;
import java.util.Scanner;

@Slf4j
@Controller
@RequestMapping("/homework2")
public class Average {
    @ResponseBody
    @GetMapping("")

    public String Average() {
        log.info("학생들의 평균점수() 동작!");

        Random random = new Random();
        int[] score = new int[30];

        for (int i = 0; i < 30; i++) {
            score[i] = ((int) (Math.random() * 41) + 60);
        }
        int total = 0;
        for (int i = 0; i < 30; i++) {
            total += score[i];
        }
        return "평균 점수는 " + total / 30 + "점 입니다.";
    }
}
