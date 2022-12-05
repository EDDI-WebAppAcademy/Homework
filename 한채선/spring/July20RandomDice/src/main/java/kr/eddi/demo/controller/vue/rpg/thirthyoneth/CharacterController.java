package kr.eddi.demo.controller.vue.rpg.thirthyoneth;

import kr.eddi.demo.controller.vue.rpg.thirthyoneth.requested.RequestedBuyItem;
import kr.eddi.demo.entity.vue.thirthyoneth.Character;
import kr.eddi.demo.entity.vue.thirthyoneth.CharacterManager;
import kr.eddi.demo.entity.vue.thirthyoneth.ShopItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/31th/character-controller")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class CharacterController {

    private CharacterManager characterManager = new CharacterManager();


    public CharacterController() {
            characterManager.makeCharacter("모험가 1", "기사");
    }


    @GetMapping("/character-status")
    public Character characterStatus() {
        log.info("characterInfo()");
        return characterManager.getCharacter();
    }

    @PostMapping("/buy_item")
    public boolean buyItems(@RequestBody RequestedBuyItem requestedBuyItem) {

        requestedBuyItem.calcBuyList(); // 총금액 계산
        log.info("BuyItems() - 구매 요청 아이템 확인: " + requestedBuyItem.getItemList() + " | " + requestedBuyItem.getTotalPrice());

        if(characterManager.getCharacter().getMoney() >= requestedBuyItem.getTotalPrice()) {
            characterManager.addItemToInventory(requestedBuyItem); // 캐릭터 인벤토리에 아이템 추가
            characterManager.calcMoney(requestedBuyItem.getTotalPrice()); // 캐릭터 소지금 차감
            log.info("캐릭터 소지금: " + characterManager.getCharacter().getMoney());
            return true;
        } else {
            return false;
        }
    }

    @GetMapping("/character-inventory")
    public List<ShopItem> characterInventory() {
        log.info("characterInventory()");
        return characterManager.getCharacter().getCharacterInventory().getInventoryItems();
    }


    /* boolean 값으로 true/ false 를 보낼 것 + 캐릭터 스테이터스 및 소비 exp 수정 기능 구현 */

    @PostMapping("/character-exp-to-status")
    public String characterExpToStatus(@RequestBody ArrayList<Integer> exchangingStatusList) {
        log.info("characterExpToStatus() - 요청 받은 교환 스테이터스 확인: " + exchangingStatusList);


        return "교환 완료";
    }
}
