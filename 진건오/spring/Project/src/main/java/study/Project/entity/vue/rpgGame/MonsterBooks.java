package study.Project.entity.vue.rpgGame;

import lombok.Getter;

@Getter
public enum MonsterBooks {
    SLIME(1, "슬라임", 50, 10, 5),
    GOBLIN(2, "고블린", 100, 20, 10),
    GNOLL(3, "놀", 200, 40, 20),
    WILD_BOAR(4, "멧돼지", 400, 100, 20),
    SKELETON(5, "스켈레톤", 350, 90, 10),
    OAK(6, "오크", 550, 150, 40),
    HOB_GOBLIN(7, "홉고블린", 650, 180, 50),
    SKELETON_ARCHER(8, "스켈레톤 아처", 300, 150, 50),
    TROLL(8, "트롤",800, 200, 80),
    ZOMBIE(10, "좀비", 350, 90, 50),
    GOBLIN_MAGICIAN(11, "고블린 메지션", 700, 500, 300),
    OGRE(12, "오우거", 1000, 250, 50),
    GHOST(13, "고스트", 750, 300, 1),
    GOLEM(14, "골렘", 2000, 400, 100),
    WYVERN(15,"와이번",3500,500,150),
    LYCH(16,"리치",2000,1000,500),
    SKELETON_KNIGHT(17, "스켈레톤 기사", 2500,700,100),
    WEREWOLF(18, "웨어울프", 5000,1000,700),
    MINOTAUR(19,"미노타우르스",10000,1500,1000),
    DRAKE(20, "드레이크",20000,5000,50000),
    LORD_OF_DEATH(21,"죽음의 군주",100000,20000,1000000),
    HYPER_METAL_SLIME(9999,"하이퍼 메탈 슬라임",1000,500000,1000000);

    private final int MONSTER_CODE;
    private final String MONSTER_NAME;
    private final int MONSTER_HP;
    private final int MONSTER_EXP;
    private final int MONSTER_DROP_MONEY;


    MonsterBooks(int MONSTER_CODE, String MONSTER_NAME, int MONSTER_HP, int MONESTER_EXP, int MONSTER_DROPMONEY) {
        this.MONSTER_CODE = MONSTER_CODE;
        this.MONSTER_NAME = MONSTER_NAME;
        this.MONSTER_HP = MONSTER_HP;
        this.MONSTER_EXP = MONESTER_EXP;
        this.MONSTER_DROP_MONEY = MONSTER_DROPMONEY;
    }
}
