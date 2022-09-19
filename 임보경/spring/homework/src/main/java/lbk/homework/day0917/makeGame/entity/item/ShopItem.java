package lbk.homework.day0917.makeGame.entity.item;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ShopItem {
    private String name;
    private Integer price;
    private String description;

    public ShopItem(String name, Integer price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }


}
