package dice.test.sixthExample.diceGameClean.entity;

import dice.test.sixthExample.diceGameClean.utillity.Dice;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {

    private Score score;

    private String playerName;

    private String defaultName = "player";

    public Player() {
        playerName = defaultName;
        score = new Score();
    }

    public void startDiceGame(Player[] player) {

        int diceNum = Dice.rollDice();
        score.calcScore(diceNum);

        if (diceNum % 2 == 0) {
            diceNum = Dice.rollDice();
        }

        for (int i = 0; i < player.length; i++) {
            Dice effectDice = new Dice();
            effectDice.effectDiceNumApply(player, playerName, diceNum, i);
        }
    }
}

