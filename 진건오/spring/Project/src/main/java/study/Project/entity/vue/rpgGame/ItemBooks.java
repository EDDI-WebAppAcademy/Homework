package study.Project.entity.vue.rpgGame;

import lombok.Getter;

@Getter
public enum ItemBooks {

    HP_POTION_I("HP 포션 1",50,"hp 200 회복", 200),
    HP_POTION_II("HP 포션 2",200,"hp 600 회복", 600),
    OLD_SWORD("낡은 검",5000000,"무기 공격력 100", 100),
    SWORD("검",50000000,"무기 공격력 200", 200),
    STEEL_SWORD("강철 검",150000000,"무기 공격력 300", 300);


    private final String ITEM_OBJECT_NAME;
    private final int ITEM_OBJECT_MONEY;
    private final String ITEM_OBJECT_DESCRIPTION;
    private final int ITEM_OBJECT_ABILITY_VALUE;

    private ItemBooks(String ITEM_OBJECT_NAME, int ITEM_OBJECT_MONEY, String ITEM_OBJECT_DESCRIPTION, int ITEM_OBJECT_ABILITY_VALUE) {
        this.ITEM_OBJECT_NAME = ITEM_OBJECT_NAME;
        this.ITEM_OBJECT_MONEY = ITEM_OBJECT_MONEY;
        this.ITEM_OBJECT_DESCRIPTION = ITEM_OBJECT_DESCRIPTION;
        this.ITEM_OBJECT_ABILITY_VALUE = ITEM_OBJECT_ABILITY_VALUE;
    }
}
