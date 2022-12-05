package kr.eddi.demo.controller.basic.dice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class DiceController {
    private Random random;
    private int diceNum;
    private StringBuilder sb;

    @GetMapping("/homework1")

    public String index(){
        sb = new StringBuilder();
        sb.append("주사위 번호: ");
        sb.append(diceNumber());
        return sb.toString();
    }
    public int diceNumber(){
        random = new Random();
        diceNum = random.nextInt(1,7);
        return diceNum;
    }
}
