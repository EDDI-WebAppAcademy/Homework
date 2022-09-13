package kr.eddi.demo.entity.vue.rpg;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Character {
    private  int level ;
    private  int hp;
    private  int mp;
    private  int itemAtk;
    private  int defaultAtk;
    private  int atk;
    private  int str;
    private  int intelligence;
    private  int dex;
    private  int vit;
    private  int def;
    private  int men;
    private  int totalLevelNeeds;
    private  int currentLevelBar;
    private  int money;
    private  String currentJob;

    public Character
            (int level, int hp, int mp, int itemAtk, int defaultAtk,
             int atk, int str, int intelligence, int dex, int vit, int def,
             int men, int totalLevelNeeds, int currentLevelBar, int money,
             String currentJob){

        this.level = level;             this. hp = hp;
        this.mp = mp;                   this.itemAtk = itemAtk;
        this.defaultAtk = defaultAtk;   this.atk = atk;
        this.str = str;                 this.intelligence = intelligence;
        this.dex = dex;                 this.vit = vit;
        this.def = def;                 this.men = men;
        this.totalLevelNeeds = totalLevelNeeds;
        this.currentLevelBar = currentLevelBar;
        this.money = money;             this.currentJob =currentJob;

    }
}
