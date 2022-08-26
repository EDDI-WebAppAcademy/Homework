package kr.eddi.demo.utility.basic.practice7_28;

import kr.eddi.demo.entity.basic.practice7_28.LottoCard;
import kr.eddi.demo.entity.basic.practice7_28.Player;

import java.util.ArrayList;
import java.util.List;

public class Score {
    private static List<Integer> score = new ArrayList<>();
   // private static int currentAlloc = 0;

    //Player의 card에 접근해서 그 카드에 적힌 번호를 numbers에 받아온뒤, 거기에 적힌 번호 6개를 가지고 환산점수를 계산후, 다시 그것을 Player의 score에 저장해줌.
    public static void calcPlayersScore(List<Player> players) {
        for (int i = 0; i < players.size(); i++) {
            LottoCard card = players.get(i).getCard();
            int[] numbers = card.getNumbers();

            if (numbers[5] == 0) {
                score.add(0);
            } else {
                score.add((numbers[0] + numbers[1] + numbers[2] + numbers[3]) *
                        numbers[4] / numbers[5]);
            }

            //currentAlloc++;
        }
    }

    public static int getScore(int idx) {
        return score.get(idx);
    }
}
