package kr.eddi.demo2.entity.vue.rpg;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Monsters {

    private String name;
    private Integer hp;
    private Integer exp;
    private Integer dropMoney;

    public Monsters (String name, Integer hp, Integer exp, Integer dropMoney) {
        this.name = name;
        this.hp = hp;
        this.exp = exp;
        this.dropMoney = dropMoney;
    }
}
