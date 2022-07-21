package kr.eddi.demo.controller.homework.first;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiceController {

    @GetMapping("/homework1")
    public int diceRoll() {
        int num = (int) ((Math.random() * 6) + 1);
        return num;
    }
}
