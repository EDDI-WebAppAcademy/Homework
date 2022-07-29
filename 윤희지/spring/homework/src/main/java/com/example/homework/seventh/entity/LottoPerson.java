package com.example.homework.seventh.entity;

import com.example.homework.utility.CustomRandom;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class LottoPerson {
    private String nickName;
    private ArrayList<Integer> lottoNums;
    private SpecialScore specialScore;

    public LottoPerson(String nickName) {
        this.nickName = nickName;
        lottoNums = new ArrayList<>();
        specialScore = new SpecialScore();
    }

}
