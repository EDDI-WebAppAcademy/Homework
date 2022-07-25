package kr.eddi.demo.controller.homework.Homework0722;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/Homework4")



public class Question5 {

    public void evenNumber() {
// [문제은행 2-5] 1~100 짝수 출력
        for (int i = 1; i <= 100; i++) {

            if (i % 2 == 0) {
                System.out.println(i);

            }
        }

    }



}
