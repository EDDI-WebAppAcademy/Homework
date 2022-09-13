package kr.eddi.demo.entity.vue.rpg;

import lombok.Getter;

@Getter
public class Monster {

    private String name;
    private int hp;
    private int exp;
    private int dropMoney;

    public Monster(String name, int hp, int exp, int dropMoney) {
        this.name = name;
        this.hp = hp;
        this.exp = exp;
        this.dropMoney = dropMoney;
    }
}
