package kr.eddi.demo.entity.vue.rpg;

public enum RatDenMonsterLists {

    RAT("시궁쥐", 200, 150, 10),
    BAT("박쥐", 250, 150, 20),
    VAMPIRE_RAT("흡혈쥐", 500, 300, 100),
    PURPLE_BAT("보라박쥐", 350, 220, 50);


    private final String MONSTER_NAME;
    private final int MONSTER_HP;
    private final int MONSTER_EXP;
    private final int MONSTER_DROP_MONEY;

    RatDenMonsterLists(String MONSTER_NAME, int MONSTER_HP, int MONSTER_EXP, int MONSTER_DROP_MONEY) {

        this.MONSTER_NAME = MONSTER_NAME;
        this.MONSTER_HP = MONSTER_HP;
        this.MONSTER_EXP = MONSTER_EXP;
        this.MONSTER_DROP_MONEY = MONSTER_DROP_MONEY;
    }

}
