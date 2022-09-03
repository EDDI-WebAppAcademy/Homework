package lbk.homework.day0903.makeGameAlone.controller;


import lbk.homework.day0903.makeGameAlone.controller.manager.MonsterManager;
import lbk.homework.day0903.makeGameAlone.entity.player.Player;
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
    private MonsterManager monsterManager= new MonsterManager();

    @GetMapping("/start/playing")
    public List summonsMonster() {
        return monsterManager.createNewMonster();
    }

    @GetMapping("/start/player")
    public Player returnPlayerInformation() {
        player = new Player();
        log.info("제대로 되나요?");
        return player;
    }

}
