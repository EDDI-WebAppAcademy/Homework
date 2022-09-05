package lbk.homework.day0903.makeGameAlone.entity.item;

import lombok.Getter;

@Getter
public class Potions extends CommonItemsProperty{

    private int amount ;


    /**
     * @param name : String : 포션이름
     * @param price : int : 가격
     * @param hp : int : 능력치(회복량)
     * @param description : String : 아이템 설명
     * itemTypeNumber [포션류 1, 무기류 2, 방어구류 3 ...]
     * */
    Potions(String name, int price, int hp, String description) {
        this.itemTypeNumber = 1;
        this.name = name;
        this.price = price;
        amount = hp;
        this.description = description;
    }
}
