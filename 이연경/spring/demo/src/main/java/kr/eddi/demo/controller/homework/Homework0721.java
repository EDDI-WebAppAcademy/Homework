package kr.eddi.demo.controller.homework;


import kr.eddi.demo.entity.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Slf4j
@Controller
@RequestMapping("/Homework2")


public class Homework0721 {

    @ResponseBody
    @GetMapping("/avg")

    public String avg() {

        // 30명의 점수
        double[] avg = {100, 80, 65, 98, 78, 65, 75, 66, 85, 89, 75, 76, 79, 100, 70, 85, 90, 80, 100, 89, 76, 89, 79, 73, 71, 72, 82, 89, 84, 69,};

        double sum = 0;

        // 총합 구하기
        for (double num : avg) {
            sum += num;
        }
       // 평균값 구하기
        double average = sum / avg.length;

        System.out.println(average);

        return "30명의 학생들의 평균 점수는 : " + average;

    }


}
