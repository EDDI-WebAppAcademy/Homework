package kr.eddi.demo.RestController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerPractice {

    @GetMapping("/homework1")
    public int diceNum() {
        int num = (int)((Math.random() * 6) + 1);
        return num;
    }
}
