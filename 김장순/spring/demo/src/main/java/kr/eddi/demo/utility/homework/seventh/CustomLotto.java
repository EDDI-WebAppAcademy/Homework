package kr.eddi.demo.utility.homework.seventh;

import kr.eddi.demo.utility.basic.third.CustomRandom;

import java.util.ArrayList;
import java.util.List;

public class CustomLotto {
    private final static int LOTTO_NUM = 6;
    private final int LOTTO_LIMIT = 45;
    private final static int CUSTOM_START = 0;
    private final static int CUSTOM_END = 99;


    public static List<Integer> makeLotto() {
        List<Integer> lottoList = new ArrayList<>();

        int cnt = 0;
        while (cnt < LOTTO_NUM) {
            Integer ranNum = CustomRandom.makeIntCustomRandom(CUSTOM_START, CUSTOM_END);
            if (!lottoList.contains(ranNum)) {
                lottoList.add(ranNum);
                cnt++;
            }
        }
        return lottoList;
    }

}
