package kr.eddi.demo.entity.vue.thirthyoneth.Monster;

import lombok.Getter;

@Getter
public class Monster {

    private String name;
    private Integer hp;
    private Integer exp;
    private Integer dropMoney;


    public Monster(String name, Integer hp, Integer exp, Integer dropMoney) {
        this.name = name;
        this.hp = hp;
        this.exp = exp;
        this.dropMoney = dropMoney;
    }
}
