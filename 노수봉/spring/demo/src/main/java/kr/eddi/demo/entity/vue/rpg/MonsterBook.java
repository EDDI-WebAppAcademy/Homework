package kr.eddi.demo.entity.vue.rpg;

import lombok.Getter;

@Getter
public class MonsterBook {

    private  int monsterId;

    private  String name;

    private  int hp;

    private int exp;

    private  int dropMoney;


    public MonsterBook(int monsterId, String name, int hp,
                       int exp, int dropMoney){
        this.monsterId = monsterId;
        this.name = name;
        this.hp = hp;
        this.exp = exp;
        this.dropMoney = dropMoney;
    }
}
