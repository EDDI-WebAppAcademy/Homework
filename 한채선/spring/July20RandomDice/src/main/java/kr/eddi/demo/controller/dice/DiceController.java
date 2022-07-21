package kr.eddi.demo.controller.dice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class DiceController {
    Random random;
    int diceNum;
    private StringBuilder sb;

    @GetMapping("/homework1")

    public String Index(){
        sb = new StringBuilder();
        sb.append("주사위 번호: ");
        sb.append(DiceNumber());
        return sb.toString();
    }
    public int DiceNumber(){
        random = new Random();
        diceNum = random.nextInt(1,7);
        return diceNum;
    }
}
