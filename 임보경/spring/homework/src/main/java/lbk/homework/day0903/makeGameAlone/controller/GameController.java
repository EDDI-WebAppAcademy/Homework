package lbk.homework.day0903.makeGameAlone.controller;


import lbk.homework.day0903.makeGameAlone.controller.manager.ShopManager;
import lbk.homework.day0903.makeGameAlone.controller.manager.MonsterManager;
import lbk.homework.day0903.makeGameAlone.entity.player.Player;
import lbk.homework.day0903.makeGameAlone.entity.player.Status;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/make-game-alone")
@CrossOrigin(origins="http://localhost:8080", allowedHeaders = "*")
public class GameController {

    private Player player;
    private MonsterManager monsterManager;
    private ShopManager shopManager;

    @GetMapping("/start/stock-up")
    public List stockUpItems() {
        shopManager = new ShopManager();
        log.info("제대로 되나요?");
        return shopManager.stockController();
    }

    @GetMapping("/start/playing")
    public List summonsMonster() {
        monsterManager = new MonsterManager();
        return monsterManager.createNewMonster();
    }

    @GetMapping("/start/status")
    public Status returnCharacterStatus() {
        player = new Player();
        return player.getCharacterStatus();
    }

}
