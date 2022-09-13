package study.Project.entity.vue.rpgGame;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import study.Project.controller.vue.thirtytwoth.request.Items;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
@NoArgsConstructor
public class InventoryManager {
     String itemName;
     String itemDescription;

     public InventoryManager(String itemName, String itemDescription) {
          this.itemName = itemName;
          this.itemDescription = itemDescription;
     }

    public InventoryManager(Items items) {
        this.itemName = items.getName();
        this.itemDescription = items.getDescription();
    }
}


