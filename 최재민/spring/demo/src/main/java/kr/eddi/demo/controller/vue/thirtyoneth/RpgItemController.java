package kr.eddi.demo.controller.vue.thirtyoneth;


import kr.eddi.demo.controller.vue.requset.Items;
import kr.eddi.demo.controller.vue.requset.RequestBuyItem;
import kr.eddi.demo.controller.vue.requset.RequestEquipItem;
import kr.eddi.demo.entity.vue.thirtyoneth.MonsterManager;
import kr.eddi.demo.entity.vue.thirtyoneth.Monsters;
import kr.eddi.demo.entity.vue.thirtyoneth.ShopItems;
import kr.eddi.demo.entity.vue.thirtyoneth.characterStatus;
import kr.eddi.demo.utility.basic.third.CustomRandom;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/31th/rpg-game")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class RpgItemController {
    MonsterManager monsterManager = new MonsterManager();

    private List<ShopItems> allShopLists = new ArrayList<>();
    private List<ShopItems> userInventoryList = new ArrayList<>();
    private List<characterStatus> CharacterStatus = new ArrayList<>();
    private List<ShopItems> equipItems = new ArrayList<>();
    public void buildDefaultItemList() {
        if (allShopLists.size() == 0) {
            allShopLists.add(new ShopItems("낡은 검", 5000000, "무기 공격력 100", 100));
            allShopLists.add(new ShopItems("검", 50000000, "무기 공격력 200", 200));
            allShopLists.add(new ShopItems("강철 검", 150000000, "무기 공격력 300", 300));
            allShopLists.add(new ShopItems("화열검", 550000000, "무기 공격력 500", 500));
            allShopLists.add(new ShopItems("군주의검", 1000000000, "무기 공격력 1000", 1000));
        }
    }

    public void buildRandomShopList (List<ShopItems> randomShopLists) {
        int everyItemSize = allShopLists.size();

        for (int i = 0; i < 10; i++) {
            ShopItems oneThing = allShopLists.get(CustomRandom.makeIntCustomRandom(0, everyItemSize - 1));
            randomShopLists.add(oneThing);
        }
    }

    @GetMapping("/random-shop-item-lists")
    public List<ShopItems> shuffleShopItems () {
        log.info("shuffleShopItems()");

        buildDefaultItemList();
        List<ShopItems> randomShopLists = new ArrayList<>();
        buildRandomShopList(randomShopLists);

        return randomShopLists;
    }

    @PostMapping("/buy-item")
    public String buyItems (@RequestBody RequestBuyItem requestBuyItem) {
        log.info("buyItems() - requestBuyItem: " + requestBuyItem);

        List<Items> tmp = requestBuyItem.getItemLists();

        for (int i = 0; i < requestBuyItem.getItemLists().size(); i++) {
            ShopItems tmpItem = new ShopItems(tmp.get(i).getName(), tmp.get(i).getPrice(),
                    tmp.get(i).getDescription(), tmp.get(i).getAtk());
            userInventoryList.add(tmpItem);
        }

        return "아이템 구매 성공!";
    }

    @PostMapping("/equip-item")
    public String equipItem (@RequestBody RequestEquipItem requestEquipItem) {
        log.info("equipItems() - requestEquipItem: " + requestEquipItem);

        List<Items> tmp = requestEquipItem.getItemLists();

        for (int i = 0; i < requestEquipItem.getItemLists().size(); i++) {
            ShopItems tmpItem = new ShopItems(tmp.get(i).getName(), tmp.get(i).getPrice(),
                    tmp.get(i).getDescription(), tmp.get(i).getAtk());
            equipItems.add(tmpItem);
        }

        return "아이템 장착 성공!";
    }

    @PostMapping("/inventory-items")
    public List<ShopItems> inventoryItems(){
        log.info("inventoryItems()");

        return userInventoryList;
    }

    @PostMapping("/character-status")
    public List<characterStatus> defaultStatus(){
        log.info("defaultStatus()");

        int equipItemsSize = equipItems.size();
        Integer totalItemAtk = 0;

        if(equipItemsSize != 0 ){
            for (int i = 0; i < equipItemsSize; i++) {
                totalItemAtk += equipItems.get(i).getAtk();
            }
        }


        CharacterStatus.add(new characterStatus(
                1,50,30,totalItemAtk,10
                ,10,10,10,10,10,0,
                10,0,0,"모험가"));

        return CharacterStatus;
    }

    @PostMapping("/defaultMnsters-List")
    public List<Monsters> defaultMonsters(){
        log.info("defaultMonsters()");

        return monsterManager.addDefaultMonsters();
    }

    @PostMapping("/hundredMonsters-List")
    public List<Monsters> hundredMonsters(){
        log.info("hundredMonsters()");

        return monsterManager.addHundredMonsters();
    }
}