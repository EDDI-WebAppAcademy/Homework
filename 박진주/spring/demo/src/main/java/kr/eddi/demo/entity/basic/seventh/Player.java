package kr.eddi.demo.entity.basic.seventh;

import kr.eddi.demo.entity.basic.utility.basic.seventh.Dice;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class Player implements Comparable<Player> { // Comparable 인터페이스를 받음
    private Score score;
    private String nickName;

    private final String DEFAULT = "anonymous";

    public Player() {
        nickName = DEFAULT;
        score = new Score();
    }

    public void gameStart(List<Player> players) {
        for (int i = 0; i < players.size(); i++) {
            int diceNum = Dice.rollDice();
            score.addScore(diceNum);

            if (diceNum % 2 == 0) {
                diceNum = Dice.rollDice();
                Dice specialDice = new Dice();
                score.addScore(diceNum);

                specialDice.checkSpecialDice(players, diceNum, i);
            }
        }
    }


    @Override
    public int compareTo(Player player) {
        int srcScore = this.getScore().getTotalScore();        // 아래 주석
        int dstScore = player.getScore().getTotalScore();       // 아래 주석

        if (srcScore > dstScore) {
            return 1;
        } else if (srcScore < dstScore) {
            return -1;
        } else {
            return 0;
        }
    }
}
  //this.getScore() 는 현재 자기 자신의 객체내에 있는 score 객체에서 정보를 가져오는 것이고
  // player.getScore()는 compareTo(Player player) 메소드 입력 인자로 들어온 정보에 대한 score 객체 정보를 가져오는 것입니다.

/**
 * - ex) player1.test(player2)
 *
 * public void test(Player player) {
 *
 * this.score += player.getScore();
 *
 * }
 *
 * player1 객체 내의 test() 매서드를 돌렸으니
 * 위 호출 방식에서는 player1.test로 호출하였으므로 this는 player1이고
 * 입력 인자로 들어온 player2는 player에 대응하게 됨.
 */