package kr.eddi.homework.entity.seventh;

import kr.eddi.homework.utility.basic.seventh.company1.Dice;
import lombok.Getter;

@Getter
public class Player {
    //이름 받고 주사위 굴리고
    private Score score;
    private String nickname;

    private final String DEFAULT = "anonymous";

    public Player(){
        nickname = DEFAULT;
        score = new Score();
    }

    public void gameStart(Player players[]){
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
