package dice.test.seventh.trySeventhExample.utillity;

import dice.test.fifthExample.third.entity.CreateRandom;

public class Lotto {
    private static int LOTTO_NUM_MAX = 99;
    private static int LOTTO_NUM_MIN = 0;
    private static int NEW_LOTTO_NUM_MIN = 1;

    public static int lottoNum() {
        return CreateRandom.makeToCreateRandom(LOTTO_NUM_MAX, LOTTO_NUM_MIN);
    }

    public static int newLottoNum() {
        return CreateRandom.makeToCreateRandom(LOTTO_NUM_MAX, NEW_LOTTO_NUM_MIN);
    }
}
