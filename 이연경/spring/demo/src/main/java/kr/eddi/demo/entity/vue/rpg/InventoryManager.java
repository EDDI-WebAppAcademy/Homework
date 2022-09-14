package kr.eddi.demo.entity.vue.rpg;


import lombok.Getter;

@Getter


public class InventoryManager {


    String itemName;
    String itemDescription;

    public InventoryManager(String itemName, String itemDescription) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
    }


}
