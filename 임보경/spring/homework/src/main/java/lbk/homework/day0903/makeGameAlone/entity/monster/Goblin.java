package lbk.homework.day0903.makeGameAlone.entity.monster;

import lombok.Getter;

@Getter
public class Goblin extends CommonMonsterProperty{

    public Goblin() {
        this.id = 1;
        this.hp = 50;
        this.atk = 10;
        this.dropMoney = 10000;
        this.expPoint = 100000;
        this.name = "고블린";
    }
}
