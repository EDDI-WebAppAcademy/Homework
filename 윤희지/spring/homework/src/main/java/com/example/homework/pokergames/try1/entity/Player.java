package com.example.homework.pokergames.try1.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

public class Player {
    private String name;
    private List<String> cards;
    private BigInteger wallet;

    public Player() {
        name = NicknameGenerator.generateRandomNickname();
        cards = new ArrayList<>();
        wallet = new BigInteger("100000000");
    }

    public Player(String name) {
        this.name = name;
        cards = new ArrayList<>();
        wallet = new BigInteger("100000000");
    }

    public void openHighCard() {
        String highCard = "";
        // 여기서 족보판정기를 가져다가 써서..아 점수..점수..점수..!!악악악~~



        System.out.println(highCard);
    }

    public void betMoney() {

    }
}
