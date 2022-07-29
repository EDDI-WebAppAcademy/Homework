package kr.eddi.demo.utility.eight.lotto;

import kr.eddi.demo.utility.fourth.RandomNumber;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class MakeLotto {

    private static final int RANDOM_LOTTO_MIN = 0;
    private static final int RANDOM_LOTTO_MAX = 99;
    private static final int RANDOM_LOTTO_LEAST = 1;
    private static final int LOTTO_SIZE = 6;


    public static List<Integer> makeLottoNumsList() {

        List<Integer> lottoNumsList = new ArrayList<>();

        for (int i = 0; i < LOTTO_SIZE; i++) {
            if (i >= 4) {
                lottoNumsList.add(lottoNumMaker(RANDOM_LOTTO_LEAST, RANDOM_LOTTO_MAX));
            } else {
                lottoNumsList.add(lottoNumMaker(RANDOM_LOTTO_MIN, RANDOM_LOTTO_MIN));
            }
        }

        return lottoNumsList;
    }

    public static List<Integer> makeLottoNumsList(int min, int max, int size) {

        List<Integer> lottoNumsList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (i >= 4) {
                lottoNumsList.add(lottoNumMaker(min, max));
            } else {
                lottoNumsList.add(lottoNumMaker(min + 1, max));
            }
        }
        return lottoNumsList;
    }


    public static int lottoNumMaker(int min, int max) {
        return RandomNumber.randomNum(min, max);
    }
}
