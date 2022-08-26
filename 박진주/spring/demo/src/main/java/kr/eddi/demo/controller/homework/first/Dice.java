package kr.eddi.demo.controller.homework.first;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController


public class Dice {
    @GetMapping("/homework1")
    public String rollDice(){
       int num = (int)(Math.random()*6 +1);
       String result = num + "이(가) 나왔습니다";
       return result;
    }

}
