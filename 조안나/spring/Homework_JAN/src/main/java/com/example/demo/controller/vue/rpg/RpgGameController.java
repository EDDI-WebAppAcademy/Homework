package com.example.demo.controller.vue.rpg;


import com.example.demo.entity.vue.rpg.*;
import com.example.demo.entity.vue.rpg.Character;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@RestController
@RequestMapping("/rpg")
@CrossOrigin(origins = "http://localhost:8080/", allowedHeaders = "*")
public class RpgGameController {
    List<Monster> monsterLists = new ArrayList<>();
    private List<ShopItems> userInventoryList = new ArrayList<>();

    @GetMapping("/random-shop-item-lists")
    public List<ShopItems> shuffleShopItems (){
        ItemsManager itemsManager = new ItemsManager();
        itemsManager.buildDefaultItemList();

        log.info("shuffleShopItems()");

        List<ShopItems> randomShopList = new ArrayList<>();
        itemsManager.buildRandomShopList(randomShopList);

        return randomShopList;
    }

    @GetMapping("/random-add-monsters")
    public List<Monster> addManyRandomMonster(){
        MonsterManager monsterManager = new MonsterManager();
        monsterManager.buildDefaultMonsterList();
        log.info("buildDefaultMonsterList()");

        monsterManager.addManyRandomMonster(monsterLists);
        log.info("addManyRandomMonster()");

        return monsterLists;
    }

    @GetMapping("/character-status")
    public Character characterStatus(){
        log.info("characterStatus()");
        return new Character();
    }

    // GetMapping 쓸 때와 PostMapping을 쓸 때를 헷갈리지 말자^^!
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

    @GetMapping("/my-inventory")
    public List<ShopItems> viewInventory(){
        log.info("viewInventory()");
        return userInventoryList;
    }

    @GetMapping("/skill-atk")
    public List<Monster> skillDamage(){
        //skills manager로 옮기기
        for (int i = 0; i < monsterLists.size(); i++) {
            monsterLists.set(i, new Monster(monsterLists.get(i).getName(),
                    monsterLists.get(i).getHp()- 30 * new Character().getAtk()));
        }
        log.info("skillDamage()");

        return monsterLists;
    }
}
