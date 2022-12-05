package lbk.homework.day0903.makeGameAlone.controller;


import lbk.homework.day0903.makeGameAlone.controller.manager.ItemManager;
import lbk.homework.day0903.makeGameAlone.controller.manager.MonsterManager;
import lbk.homework.day0903.makeGameAlone.controller.request.RequestData;
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

    @PostMapping("/start/remove-equipment")
    public void receiveRemoveEquipItemData(@RequestBody RequestData requestData) {
        log.info("요청한 데이터" + requestData.getReceiveRemoveEquipItem().toString());

        Item removeItem = requestData.getReceiveRemoveEquipItem().get(0);
        int searchCode = removeItem.getItemCode();
        int itemAtk = requestData.getReceiveRemoveEquipItem().get(0).getAmount();

        //장비창에서 삭제
        for (int i = 0; i < player.getEquipment().getEquipList().size(); i++) {
            if (searchCode == player.getEquipment().getEquipList().get(i).getItemCode()){
                player.getEquipment().getEquipList().remove(i);
            }
        }
        //인벤으로 다시 추가
        player.getInventory().getInven().add(removeItem);

        int currentAtk = player.getCharacterStatus().getAtk();
        player.getCharacterStatus().setAtk(currentAtk - itemAtk);
    }
    @PostMapping("/start/equipment")
    public void receiveEquipItemData(@RequestBody RequestData requestData) {

        // 장비창에 넣기
        Item tmpItem = requestData.getReceiveEquipItem().get(0);
        int searchCode = tmpItem.getItemCode();
        for (int i = 0; i < player.getInventory().getInven().size(); i++) {
            if (searchCode == player.getInventory().getInven().get(i).getItemCode()){
                player.getInventory().getInven().remove(i);
            }
        }
        player.getEquipment().getEquipList().add(tmpItem);

        // 아이템 타입 찾기, 무기, 방어구 등등
        String acquireItemType = requestData.getReceiveEquipItem().get(0).itemType;

        // 무기라면 공격력 추가
        if (acquireItemType.equals("무기")) {
            int itemAtk = requestData.getReceiveEquipItem().get(0).amount;
            player.getCharacterStatus().setAtkAdded(itemAtk);

            int defaultAtk = player.getCharacterStatus().getDefaultAtk();
            int atkAdded = player.getCharacterStatus().getAtkAdded();
            player.getCharacterStatus().setAtk(atkAdded + defaultAtk);

        }
    }
    @PostMapping("/start/buy-items")
    public void receiveBuyItemsData(@RequestBody RequestData requestData) {

        int size = requestData.getShoppingCart().size();
        Integer holdingAmount = player.getCharacterStatus().getMoney();
        Integer totalPrice = 0;

        for (int i = 0; i < size; i++) {
            totalPrice += requestData.getShoppingCart().get(i).price;
        }
        if (holdingAmount >= totalPrice) {
            for (int i = 0; i < size; i++) {
                player.getInventory().getInven().add(requestData.getShoppingCart().get(i));
                Integer money = player.getCharacterStatus().getMoney();
                money -= requestData.getShoppingCart().get(i).price;
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

    @GetMapping("/start/summon")
    public List summonsMonster() {
        monsterManager = new MonsterManager();
        return monsterManager.createNewMonster();
    }

    @GetMapping("/start/status")
    public Status returnCharacterStatus() {
        return player.getCharacterStatus();
    }

}
