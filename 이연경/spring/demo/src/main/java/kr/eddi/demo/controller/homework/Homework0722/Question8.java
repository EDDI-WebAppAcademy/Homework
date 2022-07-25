package kr.eddi.demo.controller.homework.Homework0722;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Random;

@Slf4j
@Controller
@RequestMapping("/Homework4")


// [문제은행 2-8] 1 ~ 100까지 숫자를 순회, 2 ~ 10 사이의 랜덤한 숫자를 선택하고 이 숫자의 배수를 출력해보도록 한다.
public class Question8 {

    public static void main(String[] args){
    int num = randomNumber();
    int sum = 0;
        for(int i = 1; i <= 100; i++) {
        if (i % num == 0) {
            sum += i;
        }
    }
        System.out.println("숫자 : " + num);
        System.out.println("숫자의 합 : " + sum);
}

    public static int randomNumber() {
        return new Random().nextInt(10 - 2) + 2;
    }
}
