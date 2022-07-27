package kr.eddi.demo.entity.six.dicegame;

import kr.eddi.demo.utility.six.afterClassDiceGame.Dice;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {

    private Score score;

    // 플레이어 닉네임은 아직까지는 사용되지 않았음
    private String nickName;

    private final String DEFAULT = "anonymous";

    public Player() {
        nickName = DEFAULT;
        score = new Score();
    }
    public void gameStart(Player[] players) {
        for (int i = 0; i < players.length; i++) {
            int diceNum = Dice.rollDice();
            score.addScore(diceNum);

            if(diceNum % 2 == 0) {
                diceNum = Dice.rollDice();
                Dice specialDice = new Dice();
                score.addScore(diceNum);

                specialDice.checkSpecialDice(players, diceNum, i);
            }
        }
    }
}
