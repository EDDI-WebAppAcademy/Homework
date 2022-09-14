package kr.eddi.demo2.entity.vue.rpg;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CharacterStatus {
    private Integer level;
    private Integer hp;
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

    public CharacterStatus(Integer level, Integer hp, Integer mp, Integer itemAtk, Integer defaultAtk, Integer atk, Integer str, Integer intelligence, Integer dex, Integer vit, Integer def, Integer men, Integer totalLevelBar, Integer currentLevelBar, Integer money, String currentJob) {
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
