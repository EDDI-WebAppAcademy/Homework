package kr.eddi.demo.utility.homework.seventh.calculation;

import kr.eddi.demo.utility.basic.third.CustomRandom;

import java.util.List;

public class CompareLotto {
    private final static int CUSTOM_START = 0;
    private final static int CUSTOM_END = 99;
    private final static int DEFAULT_PARTICIPANTS = 2;


    public static List<List<Integer>> compareLotto(List<Integer> lotto1, List<Integer> lotto2){

        List<List<Integer>> comparedLotto = List.of(lotto1,lotto2);
        int ranNum = CustomRandom.makeIntCustomRandom(CUSTOM_START,CUSTOM_END);

        for (int i = 0; i < DEFAULT_PARTICIPANTS; i++) {
            if (lotto1.get(i) == lotto2.get(i)){
                lotto2.set(i,ranNum);
                i--;
            }
        }
        return comparedLotto;
    }
}
