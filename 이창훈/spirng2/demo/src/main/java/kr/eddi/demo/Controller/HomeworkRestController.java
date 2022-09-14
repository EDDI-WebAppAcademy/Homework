package kr.eddi.demo.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class HomeworkRestController {
    @GetMapping("/")

    public int dice() {
        int min = 1;
        int max = 6;
        //주사위의 최소값은 1, 주사위의 최대값은 6
        int diceNum = new Random().nextInt(max - min + 1) + min;
        return diceNum;
    }
}
