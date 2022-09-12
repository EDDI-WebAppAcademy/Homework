package kr.eddi.demo.controller.vue.rpg.thirtyoneth;

import kr.eddi.demo.controller.vue.rpg.thirtyoneth.request.Items;
import kr.eddi.demo.controller.vue.rpg.thirtyoneth.request.RequestBuyItem;
import kr.eddi.demo.entity.vue.rpg.Monsters;
import kr.eddi.demo.entity.vue.rpg.ShopItems;
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

    private List<ShopItems> allShopLists = new ArrayList<>();
    private List<ShopItems> userInventoryList = new ArrayList<>();
    private List<Monsters> allMonsterLists = new ArrayList<>();
    private List<Monsters> currentMonsters = new ArrayList<>();
    private List<Monsters> createdMonsters = new ArrayList<>();


    public void buildDefaultMonsterList() {
        if (allMonsterLists.size() == 0) {
            allMonsterLists.add(new Monsters(1, "슬라임", 50, 10, 5));
            allMonsterLists.add(new Monsters(2, "고블린", 100, 20, 10));
            allMonsterLists.add(new Monsters(3, "놀", 200, 40, 20));
            allMonsterLists.add(new Monsters(4, "멧돼지", 400, 100, 20));
            allMonsterLists.add(new Monsters(5, "스켈레톤", 350, 90, 10));
            allMonsterLists.add(new Monsters(6, "오크", 550, 150, 40));
            allMonsterLists.add(new Monsters(7, "홉고블린", 650, 180, 50));
            allMonsterLists.add(new Monsters(8, "스켈레톤 아처", 300, 150, 50));
            allMonsterLists.add(new Monsters(9, "트롤", 800, 200, 80));
            allMonsterLists.add(new Monsters(10, "좀비", 350, 90, 50));
            allMonsterLists.add(new Monsters(11, "고블린 매지션", 700, 500, 300));
            allMonsterLists.add(new Monsters(12, "오우거", 1000, 250, 50));
            allMonsterLists.add(new Monsters(13, "고스트", 750, 300, 1));
            allMonsterLists.add(new Monsters(14, "골렘", 2000, 400, 100));
            allMonsterLists.add(new Monsters(15, "와이번", 3500, 500, 150));
            allMonsterLists.add(new Monsters(16, "리치", 2000, 1000, 500));
            allMonsterLists.add(new Monsters(17, "스켈레톤 기사", 2500, 700, 100));
            allMonsterLists.add(new Monsters(18, "웨어울프", 5000, 1000, 700));
            allMonsterLists.add(new Monsters(19, "미노타우루스", 10000, 1500, 1000));
            allMonsterLists.add(new Monsters(20, "드레이크", 20000, 5000, 50000));
            allMonsterLists.add(new Monsters(21, "죽음의 군주", 1000000, 200000, 1000000));
            allMonsterLists.add(new Monsters(9999, "하이퍼 메탈 슬라임", 1000, 5000000, 10000000));
        }
    }

    public void buildDefaultItemList() {
        if (allShopLists.size() == 0) {
            allShopLists.add(new ShopItems("낡은 검", 5000000, "무기 공격력 100", 100));
            allShopLists.add(new ShopItems("검", 50000000, "무기 공격력 200", 200));
            allShopLists.add(new ShopItems("강철 검", 150000000, "무기 공격력 300", 300));
            allShopLists.add(new ShopItems("화열검", 550000000, "무기 공격력 500", 500));
            allShopLists.add(new ShopItems("군주의검", 1000000000, "무기 공격력 1000", 1000));
            allShopLists.add(new ShopItems("아이스소드", 1500000000, "무기 공격력 2000", 2000));
            allShopLists.add(new ShopItems("칠지도", 2000000000, "무기 공격력 2000", 2000));
            allShopLists.add(new ShopItems("군주의휘장", 1000000000, "악세사리 공격력 1000", 1000));
        }
    }

    public void buildRandomShopList(List<ShopItems> randomShopLists) {
        int everyItemSize = allShopLists.size();

        for (int i = 0; i < 10; i++) {
            ShopItems oneThing = allShopLists.get(CustomRandom.makeIntCustomRandom(0, everyItemSize - 1));
            randomShopLists.add(oneThing);
        }
    }

    @GetMapping("/random-shop-item-lists")
    public List<ShopItems> shuffleShopItems() {
        log.info("shuffleShopItems()");

        buildDefaultItemList();
        List<ShopItems> randomShopLists = new ArrayList<>();
        buildRandomShopList(randomShopLists);

        return randomShopLists;
    }

    @PostMapping("/buy-item")
    public String buyItems(@RequestBody RequestBuyItem requestBuyItem) {
        log.info("buyItems() - requestBuyItem: " + requestBuyItem);

        List<Items> tmp = requestBuyItem.getItemLists();

        for (int i = 0; i < requestBuyItem.getItemLists().size(); i++) {
            ShopItems tmpItem = new ShopItems(tmp.get(i).getName(), tmp.get(i).getPrice(),
                    tmp.get(i).getDescription(), tmp.get(i).getAtk());
            userInventoryList.add(tmpItem);
        }

        return "아이템 구매 성공!";
    }

    @PostMapping("/my-inventory")
    public List<ShopItems> viewInventory() {
        log.info("myInventory()");

        return userInventoryList;
    }

    @PostMapping("/default-monsters")
    public List<Monsters> addDefaultMonsters() {
        log.info("addDefaultMonsters()");

        currentMonsters.add(new Monsters(1, "슬라임", 50, 10, 5));
        currentMonsters.add(new Monsters(2, "고블린", 100, 20, 10));
        currentMonsters.add(new Monsters(3, "놀", 200, 40, 20));

        return currentMonsters;
    }

    @PostMapping("/many-monsters")
    public List<Monsters> addManyMonsters() {
        log.info("addManyMonsters()");

        createdMonsters = new ArrayList<>();
        buildDefaultMonsterList();

        for (int i = 0; i < 100; i++) {
            createdMonsters.add(addMonster());
        }
        for (int i = 0; i < createdMonsters.size(); i++) {
            currentMonsters.add(createdMonsters.get(i));
        }
        return currentMonsters;
    }

    public Monsters addMonster() {
        buildDefaultMonsterList();
        int everyMonsterSize = allMonsterLists.size();
        Monsters monster;
        monster = allMonsterLists.get(CustomRandom.makeIntCustomRandom(0, everyMonsterSize - 1));

        return monster;
    }
}