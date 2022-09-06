package kr.eddi.demo.entity.vue.thirthyoneth.Monster;

import lombok.Getter;

@Getter
public enum MonsterBook {

    SLIME(1, "슬라임", 50, 10, 5),
    GOBLIN(2, "고블린", 100, 20, 10),
    NOB(3, "놉", 200, 40, 20),
    WILD_BOAR(4, "멧돼지", 400, 100, 20),
    SKELETON(5, "스켈레톤", 350, 90, 10),
    ORCS(6, "오크", 550, 150, 40);

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
