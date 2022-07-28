package kr.eddi.demo.entity.six.dicegame;

import kr.eddi.demo.utility.seven.dice.Dice;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Player implements Comparable<Player> {

    private Score score;

    // 플레이어 닉네임은 아직까지는 사용되지 않았음
    private String nickName;


    private final String DEFAULT = "anonymous";

    public Player() {
        nickName = DEFAULT;
        score = new Score();
    }
    public void gameStart(ArrayList<Player> players) {
        for (int i = 0; i < players.size(); i++) {
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

    @Override
    public int compareTo(Player player) {
        int srcScore = this.getScore().getTotalScore();
        int dstScore = player.getScore().getTotalScore();
        
        if(srcScore > dstScore){
            return 1;
        } else if (srcScore < dstScore) {
            return -1;
        } else {
            return 0;
        }
    }
}
