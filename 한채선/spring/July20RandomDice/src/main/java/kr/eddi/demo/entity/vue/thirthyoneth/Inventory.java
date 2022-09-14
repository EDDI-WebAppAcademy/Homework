package kr.eddi.demo.entity.vue.thirthyoneth;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@ToString
@Getter
@NoArgsConstructor
public class Inventory {

    private String characterName;

    private List<ShopItem> inventoryItems;

    public Inventory(String name) {
        inventoryItems = new ArrayList<>();
        this.characterName = name;
    }

    public void addItems(List<ShopItem> itemList) {
        for (int i = 0; i <itemList.size(); i++) {
            inventoryItems.add(itemList.get(i));
        }
        log.info("addItems() - 캐릭터 인벤토리 확인: " + this.inventoryItems);
    }
}
