package lbk.homework.day0903.makeGameAlone.entity.monster;

import lombok.Getter;

@Getter
public class Knoll extends CommonMonsterProperty {

    public Knoll() {
        this.id = 2;
        this.hp = 50000;
        this.atk = 100;
        this.dropMoney = 1000000;
        this.expPoint = 10000000;
        this.name = "놀";
    }
}