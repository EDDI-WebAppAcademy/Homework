package kr.eddi.homework.controller.sixth;

import kr.eddi.homework.entity.fifth.Series;
import kr.eddi.homework.entity.sixth.DiceGame;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/homework6")
public class DiceGameController {
    private final int PLAYER_NUMBER = 3;

    @GetMapping("/play-dice-game")
    public String playDiceGame() {
        log.info("주사위 게임을 시작합니다.");
        DiceGame diceGame = new DiceGame(PLAYER_NUMBER);
        return diceGame.runDiceGame(PLAYER_NUMBER);
    }
}
