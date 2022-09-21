package kr.eddi.demo.entity.fifth;

import kr.eddi.demo.entity.basic.fifth.DiceGame;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/fifth")
public class fifthDiceGameController {
    private int PlayerCnt = 5;
    private int LoopGame = 3;

    @GetMapping("/DICEGAME")
    public String PlayDiceGame(){
        log.info("주사위 게임을 시작합니다.");
        DiceGame diceGame = new DiceGame(5);

        return diceGame.RollDice(3);
    }
}
