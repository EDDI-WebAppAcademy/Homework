package kr.eddi.demo.controller.vue.rpg.thirthyoneth;



import kr.eddi.demo.entity.vue.thirthyoneth.*;
import kr.eddi.demo.entity.vue.thirthyoneth.Character;
import kr.eddi.demo.entity.vue.thirthyoneth.Monster.MonsterManager;
import kr.eddi.demo.entity.vue.thirthyoneth.Monster.Monster;
import kr.eddi.demo.utility.fourth.CustomRandomNumber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/31th/rpg-game-controller")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class RPGController {


    @GetMapping("/random-shop-item-lists")
    public List<ShopItem> randomShopItemLists() {
        log.info("randomShopItemLists()");
        MarketManager marketManager = new MarketManager();
        marketManager.buildRandomShopItemsList(10);

        return marketManager.getRandomShopList();
    }



    @GetMapping("/monster-list")
    public List<Monster> randomMonsterList() {
        log.info("randomMonsterList()");
        MonsterManager monsterManager = new MonsterManager();
        monsterManager.buildRandomMonsterList(10);
        return monsterManager.getRandomMonstersList();
    }



     @GetMapping("/character-info")
    public Character characterInfo() {
        log.info("characterInfo()");

        CharacterManager characterManager = new CharacterManager();
        characterManager.makeCharacter("모험가 1", "기사");
        return characterManager.getCharacter();
    }



    /* 아무리 해도 인벤토리 확인: null | 총금액: 0 로 나온다... */
    @PostMapping("/buy-items")
    public void BuyItems(@RequestBody Inventory inventory) {
        log.info("인벤토리 확인: " + inventory.getCheckedItem() + " | 총금액: " + inventory.getTotalPrice());
    }


}
