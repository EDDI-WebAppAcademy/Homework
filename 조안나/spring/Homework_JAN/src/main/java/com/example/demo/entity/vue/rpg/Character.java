package com.example.demo.entity.vue.rpg;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Character {

    private String currentJob = "원딜";
    private int level = 1;
    private int hp = 50;
    private int mp = 30;
    private int itemAtk = 0;
    private int defaultAtk = 10;
    private int atk = 10;
    private int str = 10;
    private int intelligence = 10;
    private int dex = 10;
    private int vit = 10;
    private int def = 10;
    private int men = 0;
    private int totalLevelBar = 10;
    private int currentLevelBar = 0;
    private int money = 0;
}
