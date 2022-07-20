package kr.eddi.demo.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class HomeworkRestController {
    @GetMapping("/")

    public int dice() {
        int diceNum = new Random().nextInt(6) + 1;
        return diceNum;
    }
}
