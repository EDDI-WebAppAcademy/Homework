package com.example.homework.seventh.entity;

import com.example.homework.seventh.utility.Buyer;
import com.example.homework.utility.CustomRandom;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class LottoBuyer implements Buyer {
    private String nickName;
    private ArrayList<Integer> lotto;
    private SpecialScore specialScore;
    private final int LOTTO_SIZE = 6;
    final int MIN = 0;
    final int MAX = 99;

    public LottoBuyer() {
        lotto = new ArrayList<>();
        specialScore = new SpecialScore();
    }

    public LottoBuyer(String nickName) {
        this.nickName = nickName;
        lotto = new ArrayList<>();
        specialScore = new SpecialScore();
    }

    @Override
    public void buyProduct(int quantity) {
        int randomNum;
        int temp;

        //랜덤 숫자 생성
        randomNum = CustomRandom.makeIntCustomRandom(MIN, MAX);
        lotto.add(randomNum);

        //로또 사이즈 만큼 lottoNums 리스트 객체에 요소 추가.
        for (int i = 1; i < quantity; i++) {
            temp = CustomRandom.makeIntCustomRandom(MIN, MAX);
            while (true) {
                if (randomNum != temp) {
                    lotto.add(randomNum);
                    randomNum = temp;
                    break;
                }
            }
        }
    }
}
