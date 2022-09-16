package study.Project.entity.vue.rpgGame;

import lombok.Getter;
import lombok.ToString;
import study.Project.controller.vue.thirtytwoth.request.RequestBuyItem;

@Getter
@ToString
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

    public CharacterManager() {
        this.hp = CharacterStatus.HP.getCHARACTER_ABILITY_VALUE();
        this.mp = CharacterStatus.ATK.getCHARACTER_ABILITY_VALUE();
        this.atk = CharacterStatus.ATK.getCHARACTER_ABILITY_VALUE();
        this.level = CharacterStatus.LEVEL.getCHARACTER_ABILITY_VALUE();
        this.currentJob = CharacterJob.BASIC.getCHARACTER_JOB_NAME();
        this.str = CharacterStatus.STR.getCHARACTER_ABILITY_VALUE();
        this.intelligence = CharacterStatus.INTELLIGENCE.getCHARACTER_ABILITY_VALUE();
        this.dex = CharacterStatus.DEX.getCHARACTER_ABILITY_VALUE();
        this.vit = CharacterStatus.VIT.getCHARACTER_ABILITY_VALUE();
        this.def = CharacterStatus.DEF.getCHARACTER_ABILITY_VALUE();
        this.men = CharacterStatus.MEN.getCHARACTER_ABILITY_VALUE();
        this.currentLevelBar = CharacterStatus.CURRENT_LEVEL_BAR.getCHARACTER_ABILITY_VALUE();
        this.totalLevelBar = CharacterStatus.TOTAL_LEVEL_BAR.getCHARACTER_ABILITY_VALUE();
        this.money = CharacterStatus.MONEY.getCHARACTER_ABILITY_VALUE();
    }

    public void calcCharacterMoney() {
        RequestBuyItem rb = new RequestBuyItem();
        money = this.money - rb.getTotalPrice();
    }
}
