package com.example.homework.rpg.entity;

import com.example.homework.utility.CustomRandom;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class MonsterManager {
    private List<Monster> monsterBook;
    private String[] names = {"슬라임", "고블린", "멧돼지", "스켈레톤", "오크",
            "홉고블린", "스켈레톤 아처", "트롤", "좀비", "고블린 매지션", "오우거", "고스트", "골렘",
            "와이번", "리치", "스켈레톤 기사", "웨어울프", "미노타우루스", "드레이크", "죽음의 군주",
            "하이퍼 메탈 슬라임"};
    private int[] hps = {50, 100, 200, 400, 350, 550, 650, 300, 800, 350, 700, 1000, 750,
            2000, 3500, 2000, 2500, 5000, 10000, 20000, 1000000, 1000};
    private int[] exps = {10, 20, 40, 100, 90, 150, 180, 150, 200, 90, 500, 250, 300, 400,
            500, 1000, 700, 1000, 1500, 5000, 200000, 5000000};
    private int[] dropMoneys = {5, 10, 20, 20, 10, 40, 50, 50, 80, 50, 300, 50, 1, 100, 150,
            500, 100, 700, 1000, 50000, 1000000, 10000000};

    public MonsterManager() {
        this.monsterBook = new ArrayList<>();

        for (int i = 0; i < names.length ; i++) {
            monsterBook.add(new Monster());
            monsterBook.get(i).setMonsterId(i);
            monsterBook.get(i).setName(names[i]);
            monsterBook.get(i).setHp(hps[i]);
            monsterBook.get(i).setExp(exps[i]);
            monsterBook.get(i).setDropMoney(dropMoneys[i]);
        }
    }

    public void addManyRandomMonster(List<Monster> monsterLists, int MonsterNum) {
        for (int i = 0; i < MonsterNum; i++) {
            monsterLists.add(monsterBook.get(CustomRandom.makeIntCustomRandom(0, this.monsterBook.size() - 1)));
        }
    }
}
