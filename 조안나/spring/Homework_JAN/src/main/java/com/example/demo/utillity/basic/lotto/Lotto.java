package com.example.demo.utillity.basic.lotto;

import com.example.demo.entity.basic.lotto.Buyer;
import com.example.demo.utillity.basic.CustomRandom;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ToString
public class Lotto {

    private static final int MIN = 0;
    private static final int MAX = 99;
    private static final int NUM_OF_LOTTO_NUM = 6;
    private static List<Integer> lottoNumbers;
    private static Set<Integer> lottoNumList;


    /**
     * 구매자 숫자 만큼 중복되지 않는 랜덤한 숫자를 만들어주는 메서드
     * @return
     */
    public static Set<Integer> pickingNum(List<Buyer> buyer){
        int random = CustomRandom.makeIntCustomRandom(MIN, MAX);
        lottoNumList = new HashSet<>();
        for (int i = 0; i < buyer.size(); i++) {
            lottoNumList.add(random);
        }
        return lottoNumList;
    }

    /**
     * 랜덤한 로또 번호를 중복되지 않게 List에 저장하는 메서드
     * @return 로또 번호가 담긴 List반환
     */
    public static List<Integer> saveLottoNum(Set<Integer> lottoNumList){
        lottoNumbers = new ArrayList<>();
        for (int i = 0; i < NUM_OF_LOTTO_NUM; i++) {
            lottoNumbers.add(lottoNumList.iterator().next());
        }
        return lottoNumbers;
    }

}
