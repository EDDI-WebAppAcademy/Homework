package com.example.homework.seventh_re.entity;

import com.example.homework.seventh_re.utility.LotteryShop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Player {
    private String nickName;
    private List<Integer> lotto;
    private Score score;

    public Player() {
        lotto = new ArrayList<>();
        score = new Score();
    }

    public Player(String nickName) {
        this.nickName = nickName;
        lotto = new ArrayList<>();
        score = new Score();
    }

    public void buyLotto() {
        for (int i = 0; i < lotto.size(); i++) {
            int randomNum = LotteryShop.giveLotteryNum();
            lotto.add(randomNum);
            Collections.sort(lotto);
        }
    }

}
