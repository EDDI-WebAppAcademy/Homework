package kr.eddi.demo.controller.six.dicegame.afterclass;

import kr.eddi.demo.entity.six.dicegame.Player;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/six-clean")
public class DiceGameController2 {

    private final int DEFAULT_PLAYER_NUM = 2;
    private Player[] players;
    private int playerNum;

    @GetMapping("/dice-game-starter")
    public String diceGameStarter() {
        createPlayer();
        gameStart();

        return chekWinner();
    }


    private void createPlayer() {
        players = new Player[DEFAULT_PLAYER_NUM];
        this.playerNum = DEFAULT_PLAYER_NUM;

        createPlayerObj(players, DEFAULT_PLAYER_NUM);
    }

    private void createPlayer(int playerNum) {
        players = new Player[playerNum];
        this.playerNum = playerNum;

        createPlayerObj(players, playerNum);
    }

    private void createPlayerObj(Player[] players, int playerObjectNum) {
        for (int i = 0; i < playerObjectNum; i++) {
            players[i] = new Player();
        }
    }

    /**
     * 사용자가 게임을 시작하면 주사위를 굴리고, 굴린 주사위가 짝수라면 앞서 만든 다이스 스킬 유틸리티를 사용하여 각 플레이어들에게 옵션을 적용하는 메서드
     */
    private void gameStart() {
        for (int i = 0; i < playerNum; i++) {
            players[i].gameStart(players);
        }
    }

    private String chekWinner() {
        int playerScore1 = players[0].getScore().getTotalScore();
        int playerScore2 = players[1].getScore().getTotalScore();

        if(playerScore1 > playerScore2) {
            return "플레이어 1 승리";
        } else if (playerScore1 < playerScore2) {
            return "플레이어 2 승리";
        } else {
            return "무승부";
        }
    }

}
