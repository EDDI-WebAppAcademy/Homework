package com.example.homework.rpg.controller;

import com.example.homework.rpg.entity.RpgCharacter;
import com.example.homework.rpg.entity.ShopItems;
import com.example.homework.rpg.request.Items;
import com.example.homework.rpg.request.RequestBuyItem;
import com.example.homework.rpg.request.RequestEquippedItem;
import com.example.homework.utility.CustomRandom;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/31th/rpg-game")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")

public class RpgItemController {
    private List<ShopItems> allShopLists = new ArrayList<>();
    private List<ShopItems> randomShopLists;

    public void buildDefaultItemList () {
        if(allShopLists.size() == 0) {
            allShopLists.add(new ShopItems("낡은 검", 500000, "무기 공격력 100", 100));
            allShopLists.add(new ShopItems("검", 50000000, "무기 공격력 200", 200));
            allShopLists.add(new ShopItems("강철 검", 150000000, "무기 공격력 300", 300));
            allShopLists.add(new ShopItems("화열검", 550000000, "무기 공격력 500", 500));
            allShopLists.add(new ShopItems("군주의검", 1000000000, "무기 공격력 1000", 1000));
            allShopLists.add(new ShopItems("아이스소드", 1500000000, "무기 공격력 2000", 2000));
            allShopLists.add(new ShopItems("칠지도", 2000000000, "무기 공격력 2000", 2000));
            allShopLists.add(new ShopItems("군주의휘장", 1000000000, "액세서리 공격력 1000", 1000));
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
    public List<ShopItems> shuffleShopItem () {
        log.info("shuffleShopItem()");

        buildDefaultItemList();
        randomShopLists = new ArrayList<>();
        buildRandomShopList(randomShopLists);

        return randomShopLists;
    }

    @PostMapping("/buy-items")
    public String buyItems (@RequestBody RequestBuyItem requestBuyItem) {
        log.info("buyItems() - requestBuyItem: " + requestBuyItem);

        Integer totalPrice = 0;
        Integer currentCharacterMoney = RpgCharacterController.character.getMoney();

        for (int i = 0; i < requestBuyItem.getItemLists().size(); i++) {
            totalPrice += requestBuyItem.getItemLists().get(i).getPrice();
        }
        if(totalPrice <= currentCharacterMoney) {
            RpgCharacterController.character.setInventory(requestBuyItem.getItemLists());
            RpgCharacterController.character.setMoney(currentCharacterMoney - totalPrice);

            log.info("current money :" + RpgCharacterController.character.getMoney());

            return "아이템 구매 성공!";
        } else {
            return "보유한 금전이 부족합니다.";
        }
    }

    @GetMapping("/inventory-lists")
    public List<Items> sendInventoryData() {

        log.info("sendInventoryData()");
        log.info(RpgCharacterController.character.getInventory().toString());

        return RpgCharacterController.character.getInventory();
    }

    @PostMapping("/equip-items")
    public String equipItems(@RequestBody RequestEquippedItem requestEquippedItem) {

        log.info("장착한 아이템: " + requestEquippedItem.getEquippedItemLists());

        Integer tmpItemAtk = 0;

        for (int i = 0; i < requestEquippedItem.getEquippedItemLists().size(); i++) {
            tmpItemAtk += requestEquippedItem.getEquippedItemLists().get(i).getAtk();
        }
        RpgCharacterController.character.setItemAtk(tmpItemAtk);
        return "아이템 장착 완료!";
    }
}
