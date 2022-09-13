package study.Project.controller.vue.rpgGame.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import study.Project.controller.vue.thirtytwoth.request.RequestBuyItem;
import study.Project.entity.vue.rpgGame.InventoryManager;
import study.Project.entity.vue.rpgGame.ItemBooks;
import study.Project.entity.vue.rpgGame.ShopManager;
import study.Project.utility.basic.third.CustomRandom;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/shop")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class ShopItemController {

    private List<ShopManager> shopItemLists = new ArrayList<>();
    private List<InventoryManager> inventoryList = new ArrayList<>();

    public void settingShopItemList() {
        if (shopItemLists.size() == 0) {

            shopItemLists.add(new ShopManager(ItemBooks.SWORD.getITEM_OBJECT_NAME(),
                    ItemBooks.SWORD.getITEM_OBJECT_MONEY(),
                    ItemBooks.SWORD.getITEM_OBJECT_DESCRIPTION(),
                    ItemBooks.SWORD.getITEM_OBJECT_ABILITY_VALUE()));

            shopItemLists.add(new ShopManager(ItemBooks.OLD_SWORD.getITEM_OBJECT_NAME(),
                    ItemBooks.OLD_SWORD.getITEM_OBJECT_MONEY(),
                    ItemBooks.OLD_SWORD.getITEM_OBJECT_DESCRIPTION(),
                    ItemBooks.OLD_SWORD.getITEM_OBJECT_ABILITY_VALUE()));

            shopItemLists.add(new ShopManager(ItemBooks.STEEL_SWORD.getITEM_OBJECT_NAME(),
                    ItemBooks.STEEL_SWORD.getITEM_OBJECT_MONEY(),
                    ItemBooks.STEEL_SWORD.getITEM_OBJECT_DESCRIPTION(),
                    ItemBooks.STEEL_SWORD.getITEM_OBJECT_ABILITY_VALUE()));
        }

    }

    public void randomSettingShopItemList(List<ShopManager> randomShopItemList) {
        int shopItemListSize = shopItemLists.size();

        for (int i = 0; i < 10; i++) {
            ShopManager shopItemAnything = shopItemLists.get(CustomRandom.makIntCustomRandom(0,shopItemListSize-1));
            randomShopItemList.add(shopItemAnything);
        }
    }

    @GetMapping("/shop-item")
    public List rpgGameShopITemController() {
        log.info("rpgGameController()");

        settingShopItemList();
        List<ShopManager> randomShopItemList = new ArrayList<>();
        randomSettingShopItemList(randomShopItemList);

        return randomShopItemList;
    }


    @PostMapping("/buy-item")
    public void buyItems(@RequestBody RequestBuyItem requestBuyItem) {
        log.info("buyItems()" + requestBuyItem);
        for (int i = 0; i < requestBuyItem.getItemLists().size(); i++) {

            inventoryList.add(new InventoryManager(requestBuyItem.getItemLists().get(i)));
        }
    }

    @GetMapping("/setting-inventory")
    public List requestAddInventory() {
        log.info("requestAddInventory" + inventoryList);
        return inventoryList;
    }
}
