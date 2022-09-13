package kr.eddi.demo.entity.vue.thirthyoneth.rpgDb;

import lombok.Getter;

@Getter
public enum ExpToStatus {
    EXP_TO_HP("HP", 50),
    EXP_TO_MP("MP", 50),
    EXP_TO_ATK("ATK", 5),
    EXP_TO_DEF("DEF", 5),
    EXP_TO_STR("STR", 5),
    EXP_TO_INTELLIGENCE("INT", 5),
    EXP_TO_DEX("DEX", 5),
    EXP_TO_VIT("VIT", 5),
    EXP_TO_MEN("MEN", 5);


    private String statusName;
    private int value;

    private ExpToStatus(String statusName, int value) {
        this.statusName = statusName;
        this.value = value;
    }
}
