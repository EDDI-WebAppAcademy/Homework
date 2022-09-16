package study.Project.entity.vue.rpgGame;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import study.Project.controller.vue.thirtytwoth.request.RequestBuyItem;

@Getter
@ToString
@Setter
public class CharacterManager {
    private Integer hp;
    private Integer mp;
    private Integer atk;
    private Integer defaultAtk;
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
    private Integer itemAtk;
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
        this.itemAtk = CharacterStatus.ITEM_AKT.getCHARACTER_ABILITY_VALUE();
        this.defaultAtk = CharacterStatus.DEFAULT_ATK.getCHARACTER_ABILITY_VALUE();
    }

    public CharacterManager(CharacterManager characterManager) {
        hp = characterManager.hp;
        mp = characterManager.mp;
        level = characterManager.level;
        itemAtk = characterManager.itemAtk;
        atk = characterManager.atk;
        defaultAtk = characterManager.defaultAtk;
        str = characterManager.str;
        intelligence = characterManager.intelligence;
        dex = characterManager.dex;
        vit = characterManager.vit;
        def = characterManager.def;
        men = characterManager.men;
        totalLevelBar = characterManager.totalLevelBar;
        currentLevelBar = characterManager.currentLevelBar;
        money = characterManager.money;
        currentJob = characterManager.currentJob;
    }

    public void calcCharacterMoney() {
        RequestBuyItem rb = new RequestBuyItem();
        money = this.money - rb.getTotalPrice();
    }
}
