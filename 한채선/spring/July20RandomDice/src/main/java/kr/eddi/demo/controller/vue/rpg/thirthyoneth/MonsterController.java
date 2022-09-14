package kr.eddi.demo.controller.vue.rpg.thirthyoneth;


import kr.eddi.demo.entity.vue.thirthyoneth.Monster;
import kr.eddi.demo.entity.vue.thirthyoneth.MonsterManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/31th/monster-controller")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class MonsterController {
    private MonsterManager monsterManager = new MonsterManager();

    @GetMapping("/monster-list")
    public List<Monster> randomMonsterList() {
        log.info("randomMonsterList()");
        monsterManager.buildRandomMonsterList(10);
        return monsterManager.getRandomMonstersList();
    }
}
