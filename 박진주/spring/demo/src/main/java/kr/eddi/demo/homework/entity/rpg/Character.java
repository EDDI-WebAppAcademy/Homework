package kr.eddi.demo.homework.entity.rpg;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Character {

    public static List<Character> madeCharacterList = new ArrayList<>();


    private int level;
    private int hp;
    private int mp;
    private int itemAtk;
    private int defaultAtk;
    private int atk;
    private int str;
    private int intelligence;
    private int dex;
    private int vit;
    private int def;
    private int men;
    private int totalLevelBar;
    private int currentLevelBar;
    private int money;
    private String currentJob;

    public Character(int level, int hp, int mp, int itemAtk,
                     int defaultAtk, int atk, int str, int intelligence,
                     int dex, int vit,int def, int men, int totalLevelBar,
                     int currentLevelBar, int money, String currentJob ){
        this.level = level;
        this.hp = hp;
        this.mp = mp;
        this.itemAtk = itemAtk;
        this.defaultAtk = defaultAtk;
        this.atk = atk;
        this.str = str;
        this.intelligence = intelligence;
        this.dex = dex;
        this.vit = vit;
        this.def = def;
        this.men = men;
        this.totalLevelBar = totalLevelBar;
        this.currentLevelBar = currentLevelBar;
        this.money = money;
        this.currentJob = currentJob;
    }

}
