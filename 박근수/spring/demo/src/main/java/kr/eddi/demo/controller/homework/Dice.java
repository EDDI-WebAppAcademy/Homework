package kr.eddi.demo.controller.homework;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class Dice {

    @GetMapping("/homework1")
    public String randomDice() {
        int num = (int) (Math.random()*6)+1;
        return "주사위 결과는 "+num+"입니다.";
    }
}