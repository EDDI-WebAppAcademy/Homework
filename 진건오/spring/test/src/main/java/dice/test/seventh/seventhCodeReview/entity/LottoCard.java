package dice.test.seventh.seventhCodeReview.entity;

import dice.test.fifthExample.third.entity.CreateRandom;
import lombok.Getter;

@Getter
public class LottoCard {

    private int[] numbers;

    private final int LOTTO_NUMBER_LENGTH = 6;
    private final int BIAS = 1;
    private final int MIN = 0;
    private final int MAX = 99 + BIAS;

    public LottoCard() {
        numbers = new int[LOTTO_NUMBER_LENGTH];
    }

    public int generateLottoNumber(int curIdx) {
        int tmpNum = CreateRandom.makeToCreateRandom(MAX, MIN);
        numbers[curIdx] = tmpNum;

        return tmpNum;
    }
}
