package kr.eddi.demo.controller.six.dicegame;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/six")
public class DiceGameController {

    @GetMapping("/dice-game-controller")
    public String diceGameController() {

        return null;
    }
}
