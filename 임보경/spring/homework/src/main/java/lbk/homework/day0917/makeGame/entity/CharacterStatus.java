package lbk.homework.day0917.makeGame.entity;

import lombok.Getter;

@Getter
public class CharacterStatus {

    private Integer level;

    private Integer hp;
    private Integer mp;

    private Integer atk;
    private Integer str;
    private Integer def;

    private Integer current_exp_bar;
    private Integer total_exp_bar;

    private Integer money;
    private String job;


    private final Integer INIT_LEVEL = 1;
    private final Integer INIT_HP = 50;
    private final Integer INIT_MP = 30;
    private final Integer INIT_ATK = 10;
    private final Integer INIT_STR = 10;
    private final Integer INIT_DEF = 10;
    private final Integer INIT_CURRENT_EXP_BAR = 0;
    private final Integer INIT_TOTAL_EXP_BAR = 10;
    private final Integer INIT_MONEY = 100;


    CharacterStatus (CharacterJob characterJob) {
        this.level = INIT_LEVEL;

        this.hp = INIT_HP;
        this.mp = INIT_MP;

        this.atk = INIT_ATK;
        this.str = INIT_STR;
        this.def = INIT_DEF;

        this.current_exp_bar = INIT_CURRENT_EXP_BAR;
        this.total_exp_bar = INIT_TOTAL_EXP_BAR;
        this.money = INIT_MONEY;

        this.job = characterJob.getJOB_NAME();
    }
}
