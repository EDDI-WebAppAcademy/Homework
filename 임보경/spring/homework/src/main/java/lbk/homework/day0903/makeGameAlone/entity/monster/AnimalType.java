package lbk.homework.day0903.makeGameAlone.entity.monster;

public class AnimalType extends CommonMonsterProperty{

    // 동물형 , 방어 특화
    private int def;

    AnimalType(int id, String name, int hp, int atk, int def, int dropMoney, int exp){
        this.id = id;
        this.name = name;
        this.hp = hp;
        this.atk = atk;
        this.dropMoney = dropMoney;
        this.exp = exp;

        this.def = def;
    }
}
