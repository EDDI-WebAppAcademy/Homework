package kr.eddi.demo.controller.vue.rpg.thirthyoneth;



import kr.eddi.demo.entity.vue.thirthyoneth.Monster.MonsterManager;
import kr.eddi.demo.entity.vue.thirthyoneth.Monster.Monster;
import kr.eddi.demo.entity.vue.thirthyoneth.ShopItems;
import kr.eddi.demo.utility.fourth.CustomRandomNumber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/31th/rpg-game-controller")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class RPGController {

    private List<ShopItems> allShopList = new ArrayList<>();

    public void buildDefaultItemList() {
        if (allShopList.size() == 0) {
            allShopList.add(new ShopItems("낡은 검", 5000000, "무기 공격력 100", 100));
            allShopList.add(new ShopItems("검", 5000000, "무기 공격력 200", 200));
            allShopList.add(new ShopItems("강철 검", 15000000, "무기 공격력 300", 300));
            allShopList.add(new ShopItems("화열 검", 55000000, "무기 공격력 500", 500));
            allShopList.add(new ShopItems("군주의 검", 100000000, "무기 공격력 1000", 1000));
        }
    }

    public void buildRandomShopList(List<ShopItems> randomShopLists) {
        int everyItemSize = allShopList.size();

        for (int i = 0; i < 10; i++) {
            ShopItems oneThing = allShopList.get(CustomRandomNumber.randomNum(0, everyItemSize-1));
            randomShopLists.add(oneThing);
        }
    }

    @GetMapping("/random-shop-item-lists")
    public List<ShopItems> randomShopItemLists() {
        log.info("randomShopItemLists()");
        List<ShopItems> randomShopLists = new ArrayList<>();

        buildDefaultItemList();
        buildRandomShopList(randomShopLists);

        return randomShopLists;
    }



    @GetMapping("/monster-list")
    public List<Monster> randomMonsterList() {
        log.info("randomMonsterList()");
        MonsterManager monsterManager = new MonsterManager();
        monsterManager.buildRandomMonsterList(10);
        return monsterManager.getRandomMonstersList();
    }



     @GetMapping("/character-info")
    public String characterInfo() {
        log.info("characterInfo()");
        return "hello";
    }


}
