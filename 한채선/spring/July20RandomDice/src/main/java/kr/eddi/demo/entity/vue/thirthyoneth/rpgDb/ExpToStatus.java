package kr.eddi.demo.entity.vue.thirthyoneth.rpgDb;

import lombok.Getter;

@Getter
public enum ExpToStatus {
    HP(0, "HP", 50),
    MP(1, "MP", 50),
    ATK(2, "ATK", 5),
    STR(3, "STR", 5),
    DEX(4, "DEX", 5),
    INTELLIGENCE(5, "INT", 5),
    DEF(6, "DEF", 5),
    VIT(7, "VIT", 5),
    MEN(8,"MEN", 5);



    private int statusId;
    private String statusName;
    private int value;

    private ExpToStatus(int statusId, String statusName, int value) {
        this.statusId = statusId;
        this.statusName = statusName;
        this.value = value;
    }
}
