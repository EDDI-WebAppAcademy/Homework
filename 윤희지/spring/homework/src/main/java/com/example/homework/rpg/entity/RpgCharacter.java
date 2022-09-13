package com.example.homework.rpg.entity;

import com.example.homework.rpg.request.Items;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString

public class RpgCharacter {
    private Integer level;
    private Integer currentHp;
    private Integer hp;
    private Integer currentMp;
    private Integer mp;
    private Integer itemAtk;
    private Integer defaultAtk;
    private Integer atk;
    private Integer str;
    private Integer intelligence;
    private Integer dex;
    private Integer vit;
    private Integer def;
    private Integer men;
    private Integer totalLevelBar;
    private Integer currentLevelBar;
    private Integer money;
    private String currentJob;
    private List<Items> inventory;

    public RpgCharacter(Integer level, Integer currentHp, Integer hp, Integer currentMp, Integer mp,
                     Integer itemAtk, Integer defaultAtk, Integer atk, Integer str,
                     Integer intelligence, Integer dex, Integer vit, Integer men,
                     Integer totalLevelBar, Integer currentLevelBar, Integer money, String currentJob) {

        this.level = level;
        this.currentHp = currentHp;
        this.hp = hp;
        this.currentMp = currentMp;
        this.mp = mp;
        this.itemAtk = itemAtk;
        this.defaultAtk = defaultAtk;
        this.atk = atk;
        this.str = str;
        this.intelligence = intelligence;
        this.dex = dex;
        this.vit = vit;
        this.men = men;
        this.totalLevelBar = totalLevelBar;
        this.currentLevelBar = currentLevelBar;
        this.money = money;
        this.currentJob = currentJob;

        this.inventory = new ArrayList<>();
    }
}
