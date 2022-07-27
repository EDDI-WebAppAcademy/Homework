package kr.eddi.demo.controller.homework.sixth;

import kr.eddi.demo.entity.homework.sixth.Dice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/homework4")
public class DiceGameRestController {

    @GetMapping("/play-dice-game")
    public String playDiceGame() {




        return "결과값";
    }
}
