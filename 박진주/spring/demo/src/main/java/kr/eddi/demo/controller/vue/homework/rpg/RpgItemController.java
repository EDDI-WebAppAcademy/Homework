package kr.eddi.demo.controller.vue.homework.rpg;

import kr.eddi.demo.controller.vue.homework.rpg.request.Items;
import kr.eddi.demo.controller.vue.homework.rpg.request.RequestBuyItem;
import kr.eddi.demo.entity.basic.utility.basic.third.CustomRandom;
import kr.eddi.demo.homework.entity.rpg.Character;
import kr.eddi.demo.homework.entity.rpg.ShopItems;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/31th/rpg-game")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
class RpgItemController {

    private List<ShopItems> allShopLists = new ArrayList<>();
    private List<ShopItems> userInventoryList = new ArrayList<>();

    private String buyMsg = "";


    public void buildDefaultItemList () {
        if (allShopLists.size() == 0) {
            // allShopLists는 List<ShopItems> 형태이므로 add할때 new ShopItems() 형태로 새로운 객체 생성 가능
            allShopLists.add(new ShopItems("낡은 검", 500, "무기 공격력 100", 100));
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

        checkBuyItemPrice(requestBuyItem);

        return buyMsg;
    }

    public void checkBuyItemPrice(RequestBuyItem requestBuyItem) {
        log.info("아이템 토탈 가격 체크 메소드 실행");

        int tempBuyTotalPrice = 0;
        List<Items> tmp = requestBuyItem.getItemLists();

        for (int i = 0; i < requestBuyItem.getItemLists().size(); i++) {
            tempBuyTotalPrice += requestBuyItem.getItemLists().get(i).getPrice();
            log.info(" 아이템 토탈가격: "+ tempBuyTotalPrice);
        }

        if (Character.madeCharacterList.get(0).getMoney() - tempBuyTotalPrice >= 0) {                                        // 구매리스트 가격보다 소지금이 크면
            Character.madeCharacterList.get(0).setMoney(Character.madeCharacterList.get(0).getMoney() - tempBuyTotalPrice);    // 소지금 setter 로 변경
            for (int i = 0; i < requestBuyItem.getItemLists().size(); i++) {
                ShopItems tmpItem = new ShopItems(tmp.get(i).getName(), tmp.get(i).getPrice(),
                        tmp.get(i).getDescription(), tmp.get(i).getAtk());
                userInventoryList.add(tmpItem);
            }
            buyMsg = "아이템 구매를 완료했습니다";
            log.info("구매 후 잔고: "+Character.madeCharacterList.get(0).getMoney() );
        } else {
            buyMsg = "돈이 부족하여 아이템 구매를 할 수 없습니다";
        }
    }


    @PostMapping("/my-inventory")
    public List<ShopItems> viewInventory () {
        log.info("인벤토리 보기 메소드 실행");

        return userInventoryList;
    }

}





// itemBooks: [
//   { name: 'HP 포션 I', price: 50, effect: { description: 'hp 200 회복', amount: 200 }},
//   { name: 'HP 포션 II', price: 200, effect: { description: 'hp 600 회복', amount: 600 }},
//   { name: '낡은 검', price: 5000000, effect: { description: '무기 공격력 100', atk: 100 }},
//   { name: '검', price: 50000000, effect: { description: '무기 공격력 200', atk: 200 }},
//   { name: '강철 검', price: 150000000, effect: { description: '무기 공격력 300', atk: 300 }},
//   { name: '화열검', price: 550000000, effect: { description: '무기 공격력 500', atk: 500 }},
//   { name: '군주의검', price: 1000000000, effect: { description: '무기 공격력 1000', atk: 1000 }},
//   { name: '아이스소드', price: 1500000000, effect: { description: '무기 공격력 2000', atk: 2000 }},
//   { name: '칠지도', price: 2000000000, effect: { description: '무기 공격력 2000', atk: 2000 }},
//   { name: '군주의휘장', price: 1000000000, effect: { description: '악세사리 공격력 1000', atk: 1000 }},
// ],