package kr.eddi.demo.entity.basic.practice7_26;

import kr.eddi.demo.utility.basic.practice7_26.Dice;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class Player implements Comparable<Player> {
    private Score score;
    private String nickName;

    private final String DEFAULT = "anonymous";

    public Player() {
        nickName = DEFAULT;
        score = new Score(); //Player객체 생성시 닉네임은 anonymous, score에 Score객체 생성.
    }

    public void gameStart(List<Player> players) {
        for (int i = 0; i < players.size(); i++) {
            int diceNum = Dice.rollDice(); //1~6리턴
            score.addScore(diceNum);//score에 나온 숫자 더함.

            if (diceNum % 2 == 0) {
                diceNum = Dice.rollDice();
                Dice specialDice = new Dice();
                score.addScore(diceNum); //나온 숫자가 짝수라면, 한번더 굴려서 더하고,

                specialDice.checkSpecialDice(players, diceNum, i);//나온 그 수에 따라 특수능력을 발동한다.
            }
        }
    }

    // 코드 단위로 분석하면 대가리 폭발하므로
    // 쉽게 생각한다면 아래와 같은 메커니즘으로 보도록 한다.
    // 1. 내가 비교하고자 하는 정보가 무엇인가 ? 현재 우리케이스는 totalScore
    //    그래서 비교 대상에 this.getScore().getTotalScore(),
    //    player.getScore().getTotalScore()이 사용됨
    // 2. 다음으로 한쪽이 크면 양수, 작으면 음수, 같으면 0으로 배치하면
    //    내가 비교하고자 하는 값으로 언제든지 정렬이됨
    // 3. 내부 코드 볼 필요 없음 (추상화)


    //이 메소드는 플레이어를 받아서 인접한 플레이어의 점수를 비교하는 메소드 입니다.
    @Override
    public int compareTo(Player player) {
        int srcScore = this.getScore().getTotalScore();
        int dstScore = player.getScore().getTotalScore();

        if (srcScore > dstScore) {
            return 1;
        } else if (srcScore < dstScore) {
            return -1;
        } else {
            return 0;
        }
    }
}
