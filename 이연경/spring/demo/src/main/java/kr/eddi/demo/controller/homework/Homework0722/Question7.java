package kr.eddi.demo.controller.homework.Homework0722;



import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/Homework4")



public class Question7 {

    // [문제은행 2-7] 1 ~ 100까지 숫자중 4의 배수를 더한 결과 출력

    public void plus() {
    int sum = 0;
    for (int i = 1; i <= 100; i++) {
        if (i % 4 == 0) {
            sum += i;

        }

        System.out.println("1~100 까지의 4의 배수의 총합 : " + sum);


    }


}
}
