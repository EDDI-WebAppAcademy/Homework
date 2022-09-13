package lbk.homework.day0903.makeGameAlone.entity.item;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Item {

    public int itemCode;
    public String name ;
    public Integer price ;
    public int amount;
    public String description ;
    public String itemType;



    public Item(int itemCode, String name, Integer price, int amount, String description, String itemType) {
        this.itemCode = itemCode;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.description = description;
        this.itemType = itemType;
    }
}
