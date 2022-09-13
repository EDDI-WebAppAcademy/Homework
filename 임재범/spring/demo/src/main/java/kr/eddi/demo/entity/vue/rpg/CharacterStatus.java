package kr.eddi.demo.entity.vue.rpg;

import lombok.Getter;


@Getter
public enum CharacterStatus {
    LEVEL("LEVEL", 1),
    HP("HP", 50),
    MP("MP", 30),
    ITEM_AKT("ITEM_AKT", 0),
    DEFAULT_ATK("DEFAULT_ATK", 10),
    ATK("ATK",10),
    STR("STR", 10),
    INTELLIGENCE("INTELLIGENCE", 10),
    DEX("DEX", 10),
    VIT("VIT", 10),
    DEF("DEF", 10),
    MEN("MEN", 0),
    TOTAL_LEVEL_BAR("TOTAL_LEVEL_BAR", 10),
    CURRENT_LEVEL_BAR("CURRENT_LEVEL_BAR", 0),
    MONEY("MONEY", 100000000);


    private final String CHARACTER_STATUS_TYPE;
    private final int CHARACTER_STATUS_VALUE;

    CharacterStatus(String CHARACTER_STATUS_TYPE, int CHARACTER_STATUS_VALUE) {
        this.CHARACTER_STATUS_TYPE = CHARACTER_STATUS_TYPE;
        this.CHARACTER_STATUS_VALUE = CHARACTER_STATUS_VALUE;
    }
}
