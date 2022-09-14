package kr.eddi.demo.entity.vue.thirthyoneth;


import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class ShopItem {

    private String name;
    private Integer price;
    private String description;
    private Integer atk;


    public ShopItem(String name, Integer price, String description, Integer atk){
        this.name = name;
        this.price = price;
        this.description = description;
        this.atk = atk;
    }

 /*   public ShopItem(String name, Integer price, String description, String recover) {
        this.name = name;
        this.price = price;
        this.description = description;
    }*/
}
