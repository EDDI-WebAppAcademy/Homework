package study.Project.entity.vue.rpgGame;

import lombok.Getter;
import study.Project.controller.vue.thirtytwoth.request.RequestBuyItem;

@Getter
public class CharacterManager {
    private Integer hp;
    private Integer mp;
    private Integer atk;
    private Integer level;
    private String currentJob;
    private Integer str;
    private Integer intelligence;
    private Integer dex;
    private Integer vit;
    private Integer def;
    private Integer men;
    private Integer currentLevelBar;
    private Integer totalLevelBar;
    private Integer money;

    public CharacterManager(Integer hp, Integer mp, Integer atk, Integer level,
                            String currentJob, Integer str, Integer intelligence,
                            Integer dex, Integer vit, Integer def, Integer men,
                            Integer currentLevelBar, Integer totalLevelBar, Integer money) {
        this.hp = hp;
        this.mp = mp;
        this.atk = atk;
        this.level = level;
        this.currentJob = currentJob;
        this.str = str;
        this.intelligence = intelligence;
        this.dex = dex;
        this.vit = vit;
        this.def = def;
        this.men = men;
        this.currentLevelBar = currentLevelBar;
        this.totalLevelBar = totalLevelBar;
        this.money = money;
    }

    public void calcCharacterMoney() {
        RequestBuyItem rb = new RequestBuyItem();
        money = this.money - rb.getTotalPrice();
    }
}
