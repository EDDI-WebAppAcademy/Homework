package kr.eddi.demo.entity.vue.thirthyoneth;


import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
public class Character {

    private final String KNIGHT = "기사";

    private String name;
    private int level = 1;
    private int hp;
    private int mp;
    private int atk;
    private int itemAtk = 0;
    private int def;
    private int itemDef = 0;
    private int str;
    private int intelligence;
    private int dex;
    private int vit;
    private int men;

    private int totalLevelBar = 10;
    private int currentLeverBar = 0 ;
    private Integer money = 1000000000;
    private String currentJob;

    private Inventory characterInventory;

    public Character(String name) {
        this.name = name;
        this.characterInventory = new Inventory(this.name);
    }

    public void setJob(String job) {
        switch (job) {
            case KNIGHT -> {
                this.currentJob = KNIGHT;
                this.hp += KnightStatus.KNIGHT_HP.getValue();
                this.mp += KnightStatus.KNIGHT_MP.getValue();
                this.atk += KnightStatus.KNIGHT_ATK.getValue();
                this.def += KnightStatus.KNIGHT_DEF.getValue();
                this.str += KnightStatus.KNIGHT_STR.getValue();
                this.intelligence += KnightStatus.KNIGHT_INTELLIGENCE.getValue();
                this.dex += KnightStatus.KNIGHT_DEX.getValue();
                this.vit += KnightStatus.KNIGHT_VIT.getValue();
                this.men += KnightStatus.KNIGHT_MEN.getValue();
            }
        }
    }
}
