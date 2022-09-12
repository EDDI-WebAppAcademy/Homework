package lbk.homework.day0903.makeGameAlone.controller;


import lbk.homework.day0903.makeGameAlone.controller.manager.ItemManager;
import lbk.homework.day0903.makeGameAlone.controller.manager.MonsterManager;
import lbk.homework.day0903.makeGameAlone.entity.item.Item;
import lbk.homework.day0903.makeGameAlone.entity.player.Player;
import lbk.homework.day0903.makeGameAlone.entity.player.Status;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Slf4j
@ToString
@RestController
@RequestMapping("/make-game-alone")
@CrossOrigin(origins="http://localhost:8080", allowedHeaders = "*")
public class GameController {

    private Player player = new Player();
    private MonsterManager monsterManager;
    private ItemManager itemManager;


    @PostMapping("/start/equipment")
    public void receiveEquipItemData(@RequestBody ItemManager itemManager) {
        log.info("요청된 데이터 정보: " + itemManager);

        // 장비창에 넣기
        Item tmpItem = itemManager.getReceiveEquipItem().get(0);
        int searchCode = tmpItem.getItemCode();
        for (int i = 0; i < player.getInventory().getInven().size(); i++) {
            if (searchCode == player.getInventory().getInven().get(i).getItemCode()){
                player.getInventory().getInven().remove(i);
            } else {
                log.info("없어삭제 안돼");
            }
        }

        player.getEquipment().getEquipList().add(tmpItem);
        log.info(player.getEquipment().getEquipList().toString());
        log.info("인벤" + player.getInventory().getInven().toString());
        // 아이템 타입 찾기, 무기, 방어구 등등
        String acquireItemType = itemManager.getReceiveEquipItem().get(0).itemType;

        // 무기라면 공격력 추가
        if (acquireItemType.equals("무기")) {
            int itemAtk = itemManager.getReceiveEquipItem().get(0).amount;
            int defaultAtk = player.getCharacterStatus().getDefaultAtk();
            player.getCharacterStatus().setAtk(itemAtk + defaultAtk);
            player.getCharacterStatus().setAtkAdded(itemAtk);
        }
    }
    @PostMapping("/start/buy-items")
    public void receiveBuyItemsData(@RequestBody ItemManager itemManager) {
        log.info("요청된 데이터 정보: " + itemManager);

        int size = itemManager.getShoppingCart().size();
        Integer holdingAmount = player.getCharacterStatus().getMoney();
        Integer totalPrice = 0;

        for (int i = 0; i < size; i++) {
            totalPrice += itemManager.getShoppingCart().get(i).price;
        }
        if (holdingAmount >= totalPrice) {
            for (int i = 0; i < size; i++) {
                player.getInventory().getInven().add(itemManager.getShoppingCart().get(i));
                Integer money = player.getCharacterStatus().getMoney();
                money -= itemManager.getShoppingCart().get(i).price;
                player.getCharacterStatus().setMoney(money);
                log.info("소지금액 : " + money);
                log.info("내 소지품" + player.getInventory().getInven().toString());
            }
        } else {
            log.info("돈이 없어서 구매 불가");
        }

    }
    @GetMapping("/start/current-equip")
    public List showMyEquipment() {
        return player.getEquipment().getEquipList();
    }

    @GetMapping("/start/show-my-inven")
    public List showMyInventory() {
        return player.getInventory().getInven();
    }

    @GetMapping("/start/stock-up")
    public List stockUpItems() {
        itemManager = new ItemManager();
        return itemManager.stockController();
    }

    @GetMapping("/start/playing")
    public List summonsMonster() {
        monsterManager = new MonsterManager();
        return monsterManager.createNewMonster();
    }

    @GetMapping("/start/status")
    public Status returnCharacterStatus() {
        return player.getCharacterStatus();
    }

}
