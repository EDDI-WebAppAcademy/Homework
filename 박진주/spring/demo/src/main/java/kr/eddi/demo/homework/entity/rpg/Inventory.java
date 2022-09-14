package kr.eddi.demo.homework.entity.rpg;

public class Inventory {

    private String itemName;
    private Integer price;
    private String description;
    private Integer atk;
    private String recover;

    public Inventory (String itemname, Integer price, String description, Integer atk) {
        this.itemName = itemname;
        this.price = price;
        this.description = description;
        this.atk = atk;
    }

    public Inventory (String itemname, Integer price, String description, String recover) {
        this.itemName = itemname;
        this.price = price;
        this.description = description;
        this.recover = recover;
    }
}
