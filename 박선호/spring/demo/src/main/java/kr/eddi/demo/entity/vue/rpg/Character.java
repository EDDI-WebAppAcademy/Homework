package kr.eddi.demo.entity.vue.rpg;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Character {

    private String currentJob;
    private int level;
    private int hp;
    private int mp;
    private int atk;
    private int itemAtk;
    private int str;
    private int intelligence;
    private int dex;
    private int vit;
    private int def;
    private int men;
    private int currentLevelBar;
    private int totalLevelBar;
    private int money;

    public Character() {
        this.currentJob = "모험가";
        this.level = 1;
        this.hp = 50;
        this.mp = 40;
        this.atk = 10;
        this.itemAtk = 0;
        this.str = 10;
        this.intelligence = 10;
        this.dex = 10;
        this.vit = 10;
        this.def = 10;
        this.men = 10;
        this.currentLevelBar = 0;
        this.totalLevelBar = 10;
        this.money = 0;


    }

    public void characterLevelUp() {
        this.currentLevelBar++;
//        if(this.totalLevelBar <= this.currentLevelBar){
//            this.level++;
//            this.currentLevelBar = 0;
//        }
    }
}
