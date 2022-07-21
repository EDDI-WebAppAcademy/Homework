package kr.eddi.demo.controller.homework.first;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class DiceController {

    @GetMapping("/homework1")
    public String rollDice() {
        return "무조건 6이 나오는 주사위입니다!";
    }
}
