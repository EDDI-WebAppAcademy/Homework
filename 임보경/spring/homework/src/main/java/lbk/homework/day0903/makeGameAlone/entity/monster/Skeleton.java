package lbk.homework.day0903.makeGameAlone.entity.monster;

import lombok.Getter;

@Getter
public class Skeleton extends CommonMonsterProperty{

    public Skeleton() {
        this.id = 3;
        this.hp = 100;
        this.atk = 20;
        this.dropMoney = 50000;
        this.expPoint = 100000;
        this.name = "스켈레톤";
    }
}