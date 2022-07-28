package kr.eddi.demo.entity.basic.sixth;

import kr.eddi.demo.utility.basic.sixth.company1.Dice;
import lombok.Getter;

@Getter
public class Player { // 사용자 스토리 기반으로 플레이어가 가지고 다루거나 행동하는것, 가지고 있는것들.
    private Score score;
    private String nickName; // 사용은 일단 x

    private final String DEFAULT = "anonymous";
    public Player(){
        nickName = DEFAULT;
        score = new Score();
    }

    public void gameStart(Player players[]){
        for (int i = 0; i < players.length; i++) {
            int diceNum = Dice.rollDice();
            score.addScore(diceNum);


            if (diceNum % 2 == 0){
                diceNum = Dice.rollDice();
                Dice specialDIce = new Dice();

                score.addScore(diceNum);
                specialDIce.checkSpecialDice(players,diceNum,i);
            }
        }
    }


}
