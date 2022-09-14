package kr.eddi.demo.entity.vue.rpg;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Monster {
    private Integer monsterId;

    private String name;
    private Integer hp;
    private Integer exp;
    private Integer dropMoney;

    public Monster(String name, int hp, int exp, int dropMoney) {
        this.monsterId = monsterId;
        this.name = name;
        this.hp = hp;
        this.exp = exp;
        this.dropMoney = dropMoney;
    }

    public Monster(String name, int hp) {
        this.name = name;
        this.hp = hp;

    @Getter
    public enum MonsterBooks {
        SLIME(1, "슬라임", 50, 10, 5),
        GOBLIN(2, "고블린", 100, 20, 10),
        NOLL(3, "놀", 200, 40, 20),
        BOAR(4, "멧돼지", 400, 100, 20),
        SKELETON(5, "스켈레톤", 350, 90, 10),
        ORC(6, "오크", 550, 105, 40),
        HOBGOBLIN(7, "홉고블린", 650, 180, 50),
        SKELETON_ARCHER(8, "스켈레톤 아처", 300, 150, 50),
        TROLL(9, "트롤", 800, 200, 80),
        ZOMBIE(10, "좀비", 350, 90, 50),
        GOBLIN_MAGICIAN(11, "고블린 매지션", 700, 500, 300),
        OGRE(12, "오우거", 1000, 250, 50),
        GHOST(13, "고스트", 750, 300, 1),
        GOLEM(14, "골렘", 2000, 400, 100),
        WYVERN(15, "와이번", 3500, 500, 150),
        LICH(17, "리치", 2000, 1000, 500),
        SKELETON_KNIGHT(18, "스켈레톤 기사", 2500, 700, 100),
        WEARWOLF(18, "웨어울프", 5000, 1000, 700),
        MINOTAURUS(19, "미노타우루스", 10000, 1500, 1000),
        DRAKE(20, "드레이크", 20000, 5000, 50000),
        LORD_OF_THE_DEAD(21, "죽음의 군주", 1000000, 200000, 1000000),
        HYPERMETAL_SLIME(9999, "하이퍼 메탈 슬라임", 1000, 5000000, 1000000);

        private final int monsterId;
        private final String name;
        private final int hp;
        private final int exp;
        private final int dropMoney;

        MonsterBooks(int monsterId, String name, int hp, int exp, int dropMoney) {
            this.monsterId = monsterId;
            this.name = name;
            this.hp = hp;
            this.exp = exp;
            this.dropMoney = dropMoney;
        }
    }

    @Getter
    public enum MonsterList {
        SLIME("슬라임", 50),
        GOBLIN("고블린", 100),
        NOLL("놀", 200);

        private final String name;
        private final int hp;

        MonsterList(String name, int hp) {
            this.name = name;
            this.hp = hp;
        }
    }
}