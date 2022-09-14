package lbk.homework.day0903.makeGameAlone.entity.monster;

public class DevilType extends CommonMonsterProperty{

    // 마법 공격력 추가
    private int intelligence;

    DevilType(int id, String name, int hp, int atk, int intelligence, int dropMoney, int exp){
        this.id = id;
        this.name = name;
        this.hp = hp;
        this.atk = atk;
        this.dropMoney = dropMoney;
        this.exp = exp;

        this.intelligence = intelligence;
    }
}
