package kr.eddi.demo.entity.basic.sixth.clean;

import kr.eddi.demo.utility.basic.sixth.clean.company1.Dice;
import lombok.Getter;

@Getter
public class Player {
    // 각 플레이어가 점수를 가지고 있어야함.
    private Score score;
    private String nickName;

    private final String DEFAULT = "anonymous";

    public Player() {
        nickName = DEFAULT;
        score = new Score();
    }

    public void gameStart(Player players[]) {
        for (int i = 0; i < players.length; i++) {
            int diceNum = Dice.rollDice();
            score.addScore(diceNum);

            if (diceNum % 2 == 0) {
                diceNum = Dice.rollDice();
                Dice specialDice = new Dice();
                score.addScore(diceNum);

                specialDice.checkSpecialDice(players, diceNum, i);
                // 왜 인스턴스화 시키는지 이해안감. Dice.rollDice()처럼 사용이 안되나?
            }
        }
    }


}
