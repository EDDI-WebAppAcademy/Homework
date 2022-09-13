package kr.eddi.demo.controller.vue.rpg.thirthyoneth;



import kr.eddi.demo.controller.vue.rpg.thirthyoneth.requested.RequestedBuyItem;
import kr.eddi.demo.entity.vue.thirthyoneth.*;
import kr.eddi.demo.entity.vue.thirthyoneth.Character;
import kr.eddi.demo.entity.vue.thirthyoneth.MonsterManager;
import kr.eddi.demo.entity.vue.thirthyoneth.Monster;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/31th/rpg-game-controller")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class RPGController {


    /* 점점 많아지므로 컨트롤러를 나눠야 할 듯... */

    private CharacterManager characterManager = new CharacterManager();
    private ExpChangeManager expChangeManager = new ExpChangeManager();
    private MarketManager marketManager = new MarketManager();
    private MonsterManager monsterManager = new MonsterManager();


    public RPGController() {
        characterManager.makeCharacter("모험가 1", "기사");
    }

    @GetMapping("/random-shop-item-lists")
    public List<ShopItem> randomShopItemLists() {
        log.info("randomShopItemLists()");
        marketManager.buildRandomShopItemsList(10);
        return marketManager.getRandomShopList();
    }



    @GetMapping("/monster-list")
    public List<Monster> randomMonsterList() {
        log.info("randomMonsterList()");
        monsterManager.buildRandomMonsterList(10);
        return monsterManager.getRandomMonstersList();
    }



    @GetMapping("/character-status")
    public Character characterStatus() {
        log.info("characterInfo()");
        return characterManager.getCharacter();
    }



    @PostMapping("/buy_item")
    public String BuyItems(@RequestBody RequestedBuyItem requestedBuyItem) {

        requestedBuyItem.calcBuyList(); // 총금액 계산
        log.info("BuyItems() - 구매 요청 아이템 확인: " + requestedBuyItem.getItemList() + " | " + requestedBuyItem.getTotalPrice());

        if(characterManager.getCharacter().getMoney() >= requestedBuyItem.getTotalPrice()) {
            characterManager.addItemToInventory(requestedBuyItem); // 캐릭터 인벤토리에 아이템 추가
            characterManager.calcMoney(requestedBuyItem.getTotalPrice()); // 캐릭터 소지금 차감
            log.info("캐릭터 소지금: " + characterManager.getCharacter().getMoney());
            return "구매 완료";
        } else {
            return "소지금이 부족합니다.";
        }
    }


    @GetMapping("/character-inventory")
    public List<ShopItem> characterInventory() {
        log.info("characterInventory()");
        return characterManager.getCharacter().getCharacterInventory().getInventoryItems();
    }


    @GetMapping("/exp-change-to-status")
    public List<ExpChangeStatus> expChangeToStatus() {
        log.info("expChangeToStatus()");
        return expChangeManager.getExchangeExpList();
    }
}
