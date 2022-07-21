package kr.eddi.demo.secondHw;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeworkDice {

    int num = (int)(Math.random()*6)+1;

    @GetMapping("/homework1")
    public String dice() {
        return "주사위를 굴립니다! 결과는?! " + num + "이(가) 나왔습니다!";
    }
}
