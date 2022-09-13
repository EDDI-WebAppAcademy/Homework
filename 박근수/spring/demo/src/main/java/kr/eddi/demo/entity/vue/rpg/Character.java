package kr.eddi.demo.entity.vue.rpg;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Character {

    private Integer hp = 50;
    private Integer mp = 30;
    private Integer level = 1;
    private String job = "모험가";
    private Integer itemAtk = 0;
    private Integer itemInt = 0;
    private Integer atk = 10;
    private Integer str = 10;
    private Integer intel = 10;
    private Integer dex = 10;
    private Integer vit = 10;
    private Integer def = 10;
    private Integer men = 0;
    private Integer presentLevelBar = 0;
    private Integer totalLevelBar = 10;
    private Integer money = 0;

    public Character (Integer hp, Integer mp, String job, Integer itemAtk, Integer itemInt) {
        this.hp = hp;
        this.mp = mp;
        this.job = job;
        this.itemAtk = itemAtk;
        this.itemInt = itemInt;
    }

    public Character (Integer atk, Integer str, Integer intel, Integer dex, Integer vit, Integer def, Integer men) {
        this.atk = atk;
        this.str = str;
        this.intel = intel;
        this.dex = dex;
        this.vit = vit;
        this.def = def;
        this.men = men;
    }

    public Character (Integer presentLevelBar, Integer totalLevelBar, Integer money) {
        this.presentLevelBar = presentLevelBar;
        this.totalLevelBar = totalLevelBar;
        this.money = money;
    }
}