package kr.eddi.homework.controller.first;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class DiceController {

    @GetMapping("/homework1")
    public String rollDice(){
        log.info("주사위가 던져집니다! ");
        int ran = (int)(Math.random()*6)+1;
        return "주사위의 값은 : " + ran;
    }
}
