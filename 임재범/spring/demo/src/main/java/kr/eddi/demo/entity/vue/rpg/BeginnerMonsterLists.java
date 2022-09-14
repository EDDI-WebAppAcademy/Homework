package kr.eddi.demo.entity.vue.rpg;

public enum BeginnerMonsterLists {

    RABBIT("토끼", 20, 5, 0),
    CHIPMUNK("다람쥐", 50, 10, 5),
    DOE("암사슴", 80, 20, 20),
    STAG("숫사슴", 100, 40, 10);


    private final String MONSTER_NAME;
    private final int MONSTER_HP;
    private final int MONSTER_EXP;
    private final int MONSTER_DROP_MONEY;

    BeginnerMonsterLists(String MONSTER_NAME, int MONSTER_HP, int MONSTER_EXP, int MONSTER_DROP_MONEY) {

        this.MONSTER_NAME = MONSTER_NAME;
        this.MONSTER_HP = MONSTER_HP;
        this.MONSTER_EXP = MONSTER_EXP;
        this.MONSTER_DROP_MONEY = MONSTER_DROP_MONEY;
    }
}
