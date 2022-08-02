package dice.test.seventh.seventhCodeReview.utillity;

import dice.test.seventh.seventhCodeReview.entity.LottoCard;
import dice.test.seventh.seventhCodeReview.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Score {
    private static List<Integer> score = new ArrayList<>();
    private static int currentAlloc = 0;

    public static void calcPlayersScore(List<Player> players) {
        for (int i = 0; i < players.size(); i++) {
            LottoCard card = players.get(i).getCard();
            int[] numbers = card.getNumbers();

            if (numbers[5] == 0) {
                score.add(0);
            } else {
                score.add((numbers[0] + numbers[1] + numbers[2] + numbers[3]) * numbers[4] / numbers[5]);
            }
            currentAlloc++;
        }
    }

    public static int getScore(int idx) {
        return score.get(idx);
    }
}
