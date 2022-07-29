package kr.eddi.demo.controller.homework.homework0722;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/Homework4")




public class Question4 {

    public void GuGuDan() {
// [문제은행 2-4] 구구단 7단을 출력

            for (int i = 2; i <= 9; i++) {
                System.out.println("****" + i + "단 ***");

                for (int x = 1; x >= 9; x++) {
                    System.out.println(i + "X" + x);

                    System.out.println(i + " X " + x);

                }

            }

        }


}
