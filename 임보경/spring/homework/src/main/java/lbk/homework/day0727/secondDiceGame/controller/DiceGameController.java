package lbk.homework.day0727.secondDiceGame.controller;

import lbk.homework.day0727.secondDiceGame.entity.Player;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static lbk.homework.day0727.secondDiceGame.utility.Dice.*;

@Slf4j
@RestController
@RequestMapping("/retry-game")
public class DiceGameController {
    private Player[] players;
    private int playerNum = 3; // 임시 추후 변경 가능.
    private int diceNumFirst;
    private int diceNumSecond;
    private static final int EQUAL = 1;
    private static final int LUCKY = 3;
    private static final int GAME_OVER = 4;
    private static final int POOR = 5;

    @GetMapping("/dice-game-restart")
    public String gameStart(){
        castPlayer(playerNum);
        playingGame();
        return findWinner();
    }

    public void playingGame() {
        for (int playerIdx = 0; playerIdx < playerNum; playerIdx++) {
            diceNumFirst = rollDice();
            calScoreAfterRollDice(diceNumFirst, playerIdx);

            if (diceNumFirst % 2 == 0) {
                diceNumSecond = rollDice();
                calScoreAfterRollDice(diceNumSecond, playerIdx);
                eventOccurs(diceNumSecond, playerIdx);
            }
        }
    }

    public void eventOccurs(int eventNumber, int playerIdx) {
        for (int i = 0; i < players.length; i++) {

            switch (eventNumber) {

                case EQUAL :

                    players[i].getScore().calScore(-2);
                    break;

                case LUCKY :

                    if (i == playerIdx) { continue;}
                    players[i].getScore().calScore(-3);
                    players[playerIdx].getScore().calScore(3);
                    break;

                case GAME_OVER :

                    players[playerIdx].getScore().calScore(-9999);
                    break;

                case POOR :

                    if (i == playerIdx) { continue;}
                    players[playerIdx].getScore().calScore(-2);
                    players[i].getScore().calScore(2);
                    break;
            }
        }
    }

   public void calScoreAfterRollDice(int diceNum, int playerIdx) { // 애자일 보드 main 2.2내용
      players[playerIdx].getScore().calScore(diceNum);
    }

    public void castPlayer(int playerNumber) { // 플레이어 수만큼의 플레이어 객체 배열 생성.
        players = new Player[playerNumber];

        for (int i = 0; i < players.length; i++) {
            players[i] = new Player();
        }
    }

    public String viewScoreAllMember() {
        String msg = "";
        for (int playerIdx = 0 ; playerIdx < players.length; playerIdx++) {
            msg += (playerIdx + 1) + "번째 플레이어의 점수 :" + players[playerIdx].getScore().getTotalScore() + " ";
        }
        return msg;
    }

    public String findWinner() {
        String scoreResult = viewScoreAllMember();
        int heightScore = 0;
        int playersScore;
        String winner = "";

        for (int i = 0 ; i < players.length; i++) {
           playersScore = players[i].getScore().getTotalScore();

            if (heightScore < playersScore) {
                heightScore = playersScore;
                winner = "플레이어" + (i + 1) + " 가 승리했습니다.";
            }
        }
        return scoreResult + "\n" + winner;
    }
}


