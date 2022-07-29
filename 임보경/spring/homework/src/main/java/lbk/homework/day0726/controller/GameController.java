package cls.i.lecture.day0726.controller;

import cls.i.lecture.day0726.entity.Dice;
import cls.i.lecture.day0726.entity.Player;
import cls.i.lecture.day0726.entity.Score;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/dice-game")
public class GameController {

    private Dice dice = new Dice();
    private Player player = new Player();
    private Score score;




    @GetMapping("/start-game")
    public String startGame() {
        log.info("스타트게임.");
        score  = new Score();
        int playerNum = player.getPlayerNum();
        log.info(playerNum+"의 플레이어가 참여합니다.");

        int firstResult;
        int activePlayer;


        while (true) {
            activePlayer = player.getActivePlayer();
            // 게임 종료 조건 1.
            if (activePlayer == playerNum) {

                if (score.isWinner()) {
                    //모두 동점
                    continue;
                } else {
                    break;
                }

            } else {

                log.info("첫번재 주사위를 던집니다.");
                firstResult = dice.rollFirstDice();

                if (firstResult == 0) {
                    log.info("첫번째 주사위에서 짝수가 나왔습니다. 두번째 주사위를 던집니다.");
                    dice.rollSecondDice(activePlayer);
                    player.setActivePlayer(activePlayer + 1);

                } else if (firstResult == 1) {
                    log.info("첫번째 주사위에서 홀수가 나왔습니다. 다음 플레이어로 진행합니다.");
                    player.setActivePlayer(activePlayer + 1);
                }
                log.info(score.playersScore.toString());
            }
        }

        return score.playersScore.toString();
    }
}

