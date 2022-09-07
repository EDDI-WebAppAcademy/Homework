package kr.eddi.demo.entity.vue.thirthyoneth;


import lombok.Getter;

@Getter
public class Character {

    private final String KNIGHT = "기사";


    private String name;
    private String level;
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
    private int money = 0;
    private String currentJob;

    public Character(String name) {
        this.name = name;
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
