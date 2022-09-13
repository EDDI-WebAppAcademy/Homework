package com.example.homework.rpg.controller;

import com.example.homework.rpg.entity.Monster;
import com.example.homework.rpg.entity.MonsterManager;
import com.example.homework.rpg.request.RemoveMonsterIdx;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/31th/rpg-game")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
@ToString


public class RpgMonsterController {

    private List<Monster> monsterLists = new ArrayList<>();
    private final int MONSTER_NUM = 100;

    @GetMapping("/add-random-monsters")
    public List<Monster> addRandomMonsters () {
        log.info("addRandomMonsters()");

        MonsterManager monsterManager = new MonsterManager();
        monsterManager.addManyRandomMonster(monsterLists, MONSTER_NUM);

        return monsterLists;
    }

    @PostMapping("/remove-monster")
    public List<Monster> removeMonster (@RequestBody RemoveMonsterIdx removeMonsterIdx) {
        log.info("removeMonster()");
        log.info("삭제할 몬스터 idx: " + removeMonsterIdx.getRemoveMonsterIdx());

        monsterLists.remove(Integer.parseInt(removeMonsterIdx.getRemoveMonsterIdx()));
        log.info(String.valueOf(monsterLists));

        return monsterLists;
    }

}
