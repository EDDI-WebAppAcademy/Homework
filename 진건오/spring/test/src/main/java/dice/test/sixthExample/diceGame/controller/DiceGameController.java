package dice.test.sixthExample.diceGame.controller;

import dice.test.sixthExample.diceGame.entity.RunDiceGame;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DiceGameController {

    // 플레이어 수
    private int numberOfPlayers = 4;

    //플레이어 시작 점수
    private int startPlayersScore = 10;

    @ResponseBody
    @GetMapping("/dice-game-start")
    public String viewDiceGameStart() {
        String runDiceGame = RunDiceGame.startDiceGame(numberOfPlayers, startPlayersScore);

        return runDiceGame;
    }
}
