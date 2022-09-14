package kr.eddi.demo2.controller.vue.rpg.thirtyoneth;

import kr.eddi.demo2.controller.vue.rpg.thirtyoneth.request.Items;
import kr.eddi.demo2.controller.vue.rpg.thirtyoneth.request.RequestBuyItem;
import kr.eddi.demo2.entity.vue.rpg.ShopItems;
import kr.eddi.demo2.utility.basic.third.CustomRandom;
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

    public void buildDefaultItemList () {
        //베이스 리스트를 만들어 놓는게 좋을듯
       /* itemBooks: [
        { name: 'HP 포션 I', price: 50, effect: { description: 'hp 200 회복', amount: 200 }},
        { name: 'HP 포션 II', price: 200, effect: { description: 'hp 600 회복', amount: 600 }},
        { name: '낡은 검', price: 5000000, effect: { description: '무기 공격력 100', atk: 100 }},
        { name: '검', price: 50000000, effect: { description: '무기 공격력 200', atk: 200 }},
        { name: '강철 검', price: 150000000, effect: { description: '무기 공격력 300', atk: 300 }},
        { name: '화열검', price: 550000000, effect: { description: '무기 공격력 500', atk: 500 }},
        { name: '군주의검', price: 1000000000, effect: { description: '무기 공격력 1000', atk: 1000 }},
        { name: '아이스소드', price: 1500000000, effect: { description: '무기 공격력 2000', atk: 2000 }},
        { name: '칠지도', price: 2000000000, effect: { description: '무기 공격력 2000', atk: 2000 }},
        { name: '군주의휘장', price: 1000000000, effect: { description: '악세사리 공격력 1000', atk: 1000 }},
      ],*/
        //편의를 위해 우선 아이템만 배치
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
            ShopItems oneThing =  allShopLists.get(CustomRandom.makeIntCustomRandom(0, everyItemSize -1));
            randomShopLists.add(oneThing);
        }
    }
    @GetMapping("/random-shop-item-lists")
    public List<ShopItems> shuffleShopItems () { //샵아이템리스트 전달
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

    @PostMapping("/my-inventory")
    public List<ShopItems> viewInventory () {
        log.info("shuffleShopItems()");

        return userInventoryList;
    }
}