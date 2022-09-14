package kr.eddi.demo.homework.entity.rpg;


import lombok.Getter;

@Getter
public class Monster {

    private String id;
    private String name;
    private Integer hp;
    private Integer exp;
    private Integer dropMoney;

    private final int MONSTER_TYPE_NUM = 7;

    public Monster(Integer id, String name, Integer hp, Integer exp, Integer dropMoney){
        this.name = name;
        this.hp = hp;
        this.exp = exp;
        this.dropMoney = dropMoney;
    }

}
