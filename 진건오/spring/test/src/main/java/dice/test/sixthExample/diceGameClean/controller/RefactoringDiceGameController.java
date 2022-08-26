package dice.test.sixthExample.diceGameClean.controller;

import dice.test.sixthExample.diceGameClean.entity.Player;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RefactoringDiceGameController {

    private final int numberOfPlayers = 4;

    private Player[] players;
    private static String str = "";


    @ResponseBody
    @GetMapping("cleanCode-dice-game-start")
    public String diceGameStart() {

        createPlayer();
        gameStart();

        return checkWinner(players, numberOfPlayers);
    }

    public void createPlayer() {
        players = new Player[numberOfPlayers];

        createPlayerP(players, numberOfPlayers);
    }

    public void createPlayerP(Player player[], int playerNum) {
        for (int i = 0; i < playerNum; i++) {
            player[i] = new Player();
        }
    }

    public void gameStart() {
        for (int i = 0; i < players.length; i++) {
            players[i].startDiceGame(players);
        }
    }

    public static String checkWinner(Player player[],int playerNum) {
        int baseScore = 0;
        int playerScore = 0;

        for (int i = 0; i < playerNum; i++) {
            playerScore = player[i].getScore().getTotalScore();
        }

        if (playerScore > baseScore) {
            baseScore = playerScore;
        } else if (playerScore > baseScore) {
            str += "플레이어 점수:["+baseScore+"]";
        } else {
            str += "무승부";
        }
        return str;
    }
}
