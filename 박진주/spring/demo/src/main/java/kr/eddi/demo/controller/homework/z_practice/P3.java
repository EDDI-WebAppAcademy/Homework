package kr.eddi.demo.controller.homework.z_practice;

import kr.eddi.demo.homework.entity.second.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping("/homework23")

public class P3 {

    @ResponseBody
    @GetMapping()
    public Student getAverage() {
        log.info("학생 점수 평균 구하기");

        Student student = new Student();



        int[] s = new int[30];
        int sum = 0;

        for (int i = 0; i < s.length ; i++) {
            s[i] = (int)(Math.random()*41)+60;
            //System.out.println(s[i]);
            student.setScore(new int[]{s[i]});
            sum += s[i];
            student.setSum(sum);
        }

        int average = sum/30;
        student.setAverage(average);

        return student;

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