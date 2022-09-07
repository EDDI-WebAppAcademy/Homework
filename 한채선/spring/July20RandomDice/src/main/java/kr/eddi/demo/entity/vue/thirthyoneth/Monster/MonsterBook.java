package kr.eddi.demo.entity.vue.thirthyoneth.Monster;

import lombok.Getter;

@Getter
public enum MonsterBook {

    SLIME(1, "슬라임", 50, 10, 5),
    GOBLIN(2, "고블린", 100, 20, 10),
    NOB(3, "놉", 200, 40, 20),
    WILD_BOAR(4, "멧돼지", 400, 100, 20),
    SKELETON(5, "스켈레톤", 350, 90, 10),
    ORCS(6, "오크", 550, 150, 40),
    HOB_GOBLIN(7, "홉고블린", 650, 100, 50),
    SKELETON_ARCHER(8, "스켈레톤 아처", 300, 150, 50),
    TROLL(9, "트롤", 800, 200, 80),
    ZOMBIE(10, "좀비", 350, 90, 50),
    GOBLIN_MAGICIAN(11, "고블린 매지션", 700, 500, 300),
    ORGE(12, "오거", 1000, 250, 50),
    GHOST(13, "고스트", 750, 300, 1),
    GOLEM(14, "골렘", 2000, 400, 100),
    WYVERN(15, "와이번", 3500, 500, 150),
    LICH(16, "리치", 2000, 1000, 500),
    SKELETON_KNIGHT(17, "스켈레톤 기사", 2500, 700, 100),
    WERE_WOLF(18, "웨어울프", 5000, 1000, 50),
    MINOTAUROS(19, "미노타우르스", 10000, 1500, 1000),
    DRAKE(20, "드레이크", 20000, 5000, 50000),
    LORD_OF_DEATH(21, "죽음의 군주", 1000000, 20000, 100000),
    HYPER_METAL_SLIME(9999, "하이퍼 메탈 슬라임", 1000, 5000000,  10000000);

    private final int monsterId;
    private final String name;
    private final int hp;
    private final int exp;
    private final int dropMoney;

    private MonsterBook(int monsterId, String name, int hp, int exp, int dropMoney) {
        this.monsterId = monsterId;
        this.name = name;
        this.hp = hp;
        this.exp = exp;
        this.dropMoney = dropMoney;
    }
}
