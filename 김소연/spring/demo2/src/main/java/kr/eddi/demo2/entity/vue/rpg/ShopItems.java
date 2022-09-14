package kr.eddi.demo2.entity.vue.rpg;

import lombok.Getter;

@Getter

public class ShopItems {
    //정석은 enum 맞지만 그냥 고
    private String name;
    private Integer price;
    private String description;
    private Integer atk;
    private String recover;

    public ShopItems (String name, Integer price, String description, Integer atk){
        this.name = name;
        this.price = price;
        this.description = description;
        this.atk = atk;
    }

    public ShopItems (String name, Integer price, String descirption, String recover){
        this.name = name;
        this.price = price;
        this.description = description;
        this.recover = recover;
    }
}
