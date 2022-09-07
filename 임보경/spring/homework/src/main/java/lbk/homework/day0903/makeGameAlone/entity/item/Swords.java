package lbk.homework.day0903.makeGameAlone.entity.item;

import java.math.BigInteger;

public class Swords extends CommonItemsProperty{

    private int itemAtk ;

    /**
     * @param name : String : 포션이름
     * @param price : int : 가격
     * @param atk : int : 능력치(추가 공격력)
     * @param description : String : 아이템 설명
     * itemTypeNumber [포션류 1, 무기류 2, 방어구류 3 ...]
     * */
    Swords(String name, Integer price, int atk, String description) {
        this.itemTypeNumber = 2;
        this.name = name;
        this.price = price;
        this.itemAtk = atk;
        this.description = description;
    }
}
