package kr.eddi.demo.controller.basic.sixth;

/*
import kr.eddi.demo.entity.basic.sixth.clean.Player;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/sixth-clean")


public class SixthCleanDiceGameController {
    private final int DEFAULT_PLAYER_NUM = 2;
    private Player[] players;
    private int playerNum;

    @GetMapping("/dice-game-starter")

    public String diceGameStarter() {
        createPlayer();
        gameStart();

        return "고고싱";
        return checkWinner();
    }

    public void createPlayer() {
        players = new Player[DEFAULT_PLAYER_NUM];
        this.playerNum = DEFAULT_PLAYER_NUM;
        createPlayerObj(players, DEFAULT_PLAYER_NUM);
    }

    public void createPlayer(int playerNum) {
        players = new Player[playerNum];
        this.playerNum = playerNum;
        createPlayerObj(players, playerNum);
    }

    public void createPlayerObj(Player player[], int playerObjNum) {
        for (int i = 0; i < playerObjNum; i++) {
            player[i] = new Player();
        }
    }

    public void gameStart() {
        for (int i = 0; i < playerNum; i++) {
            //players[i].gameStart();
            players[i].gameStart(players);
        }
    }

    // 최종 승자 판정
    public void checkWinner() {


        public String checkWinner () {
            int playerScore1 = players[0].getScore().getTotalScore();
            int playerScore2 = players[1].getScore().getTotalScore();

            if (playerScore1 > playerScore2) {
                return "플레이어 1 승리!";
            } else if (playerScore1 < playerScore2) {
                return "플레이어 2 승리!";
            } else {
                return "무승부";
            }
        }
    }
}

 */


