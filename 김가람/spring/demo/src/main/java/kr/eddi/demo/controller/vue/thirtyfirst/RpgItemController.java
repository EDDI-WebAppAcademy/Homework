package kr.eddi.demo.controller.vue.thirtyfirst;

import kr.eddi.demo.controller.vue.thirtysecond.request.RequestBuyItem;
import kr.eddi.demo.entity.vue.thirtiyfirst.ShopItems;
import kr.eddi.demo.utility.basic.third.CustomRandom;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/31st/rpg-game")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class RpgItemController {
    private List<ShopItems> allShopList = new ArrayList<>();

    public void buildDefaultItemList () {
        if (allShopList.size() == 0) {
            allShopList.add(new ShopItems("HP 포션 I", 50, "hp 200 회복", "200"));
            allShopList.add(new ShopItems("HP 포션 II", 200, "hp 600 회복", "600"));
            allShopList.add(new ShopItems("낡은 검", 5000000, "무기 공격력 100", 100));
            allShopList.add(new ShopItems("검", 50000000, "무기 공격력 200", 200));
            allShopList.add(new ShopItems("강철 검", 150000000, "무기 공격력 300", 300));
            allShopList.add(new ShopItems("화열 검", 550000000, "무기 공격력 200", 200));
            allShopList.add(new ShopItems("군주의 검", 1000000000, "무기 공격력 200", 200));
            allShopList.add(new ShopItems("아이스소드", 1500000000, "무기 공격력 2000", 2000));
            allShopList.add(new ShopItems("칠지도", 2000000000, "무기 공격력 2000", 200));
            allShopList.add(new ShopItems("군주의휘장", 1000000000, "악세사리 공격력 1000", 1000));
        }
    }

    public void buildRandomShopList (List<ShopItems> randomShopLists) {
        int everyItemSize = allShopList.size();

        for (int i = 0; i < 10; i++) {
            ShopItems oneThing = allShopList.get(CustomRandom.makeIntCustomRandom(0, everyItemSize - 1));
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

        return "아이템 구매 성공!";
    }
}
