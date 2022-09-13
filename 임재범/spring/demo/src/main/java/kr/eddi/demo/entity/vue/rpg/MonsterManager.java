package kr.eddi.demo.entity.vue.rpg;

import lombok.Getter;

@Getter
public class MonsterManager {
    private String name;
    private Integer hp;
    private Integer exp;
    private Integer drop;


    public MonsterManager(String name, Integer hp, Integer exp, Integer drop) {
        this.name = name;
        this.hp = hp;
        this.exp = exp;
        this.drop = drop;
    }
}
