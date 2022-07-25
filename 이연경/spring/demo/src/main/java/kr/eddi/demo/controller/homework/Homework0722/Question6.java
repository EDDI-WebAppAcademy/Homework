package kr.eddi.demo.controller.homework.Homework0722;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/Homework4")



public class Question6 {
    // [문제은행 2-6] 1 ~ 100까지 숫자중 3의 배수만 출력
    public void oddNumber() {

        for (int i = 0; i <= 100; i++) {

            if (i % 3 == 0) {
                System.out.println(i);

            }
        }

    }

}
