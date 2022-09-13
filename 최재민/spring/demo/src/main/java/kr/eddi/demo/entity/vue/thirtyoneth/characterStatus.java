package kr.eddi.demo.entity.vue.thirtyoneth;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class characterStatus {
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

    public characterStatus(
            Integer level,Integer hp,Integer mp,Integer itemAtk,Integer defaultAtk,
            Integer str,Integer intelligence,Integer dex,Integer vit,Integer def,Integer men,
            Integer totalLevelBar,Integer currentLevelBar,Integer money,String currentJob
    )
    {
        this.level = level;
        this.hp = hp;
        this.mp = mp;
        this.itemAtk = itemAtk;
        this.defaultAtk = defaultAtk;
        this.atk = defaultAtk + itemAtk;
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
