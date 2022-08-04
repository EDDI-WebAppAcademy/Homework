package kr.eddi.demo.utility.basic.nineth;

import kr.eddi.demo.entity.basic.nineth.LottoCard;
import kr.eddi.demo.entity.basic.nineth.LottoPlayer;

import java.util.ArrayList;
import java.util.List;

public class LottoScore {
    private static List<Integer> score = new ArrayList<>();
    private static int currentAlloc = 0;

    //[ (숫자1 + 숫자2 + 숫자3 + 숫자4) * 숫자5 ] / 숫자6
    public static void calcPlayersScore(List<LottoPlayer> lottoPlayers) {
        for (int i = 0; i < lottoPlayers.size(); i++) {
            LottoCard card = lottoPlayers.get(i).getCard();
            int[] numbers = card.getNumbers();

            if (numbers[5] == 0) { // ArithmeticException 예외
                score.add(0);
            } else {
                score.add((numbers[0] + numbers[1] + numbers[2] + numbers[3]) *
                        numbers[4] / numbers[5]);
            }
            currentAlloc++;
        }
    }

    public static int getScore(int idx) {
        return score.get(idx);
    }
}
