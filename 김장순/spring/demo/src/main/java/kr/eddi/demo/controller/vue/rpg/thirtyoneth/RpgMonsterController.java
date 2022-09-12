package kr.eddi.demo.controller.vue.rpg.thirtyoneth;

import kr.eddi.demo.entity.vue.rpg.Monsters;
import kr.eddi.demo.utility.basic.third.CustomRandom;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/31th/rpg-game2")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class RpgMonsterController {

    private List<Monsters> allMonsterLists = new ArrayList<>();
    private List<Monsters> currentMonsters = new ArrayList<>();
    private List<Monsters> createdMonsters = new ArrayList<>();

    public void buildDefaultMonsterList() {
        if (allMonsterLists.size() == 0) {
            allMonsterLists.add(new Monsters(1, "슬라임", 50, 10, 5));
            allMonsterLists.add(new Monsters(2, "고블린", 100, 20, 10));
            allMonsterLists.add(new Monsters(3, "놀", 200, 40, 20));
            allMonsterLists.add(new Monsters(4, "멧돼지", 400, 100, 20));
            allMonsterLists.add(new Monsters(5, "스켈레톤", 350, 90, 10));
            allMonsterLists.add(new Monsters(6, "오크", 550, 150, 40));
            allMonsterLists.add(new Monsters(7, "홉고블린", 650, 180, 50));
            allMonsterLists.add(new Monsters(8, "스켈레톤 아처", 300, 150, 50));
            allMonsterLists.add(new Monsters(9, "트롤", 800, 200, 80));
            allMonsterLists.add(new Monsters(10, "좀비", 350, 90, 50));
            allMonsterLists.add(new Monsters(11, "고블린 매지션", 700, 500, 300));
            allMonsterLists.add(new Monsters(12, "오우거", 1000, 250, 50));
            allMonsterLists.add(new Monsters(13, "고스트", 750, 300, 1));
            allMonsterLists.add(new Monsters(14, "골렘", 2000, 400, 100));
            allMonsterLists.add(new Monsters(15, "와이번", 3500, 500, 150));
            allMonsterLists.add(new Monsters(16, "리치", 2000, 1000, 500));
            allMonsterLists.add(new Monsters(17, "스켈레톤 기사", 2500, 700, 100));
            allMonsterLists.add(new Monsters(18, "웨어울프", 5000, 1000, 700));
            allMonsterLists.add(new Monsters(19, "미노타우루스", 10000, 1500, 1000));
            allMonsterLists.add(new Monsters(20, "드레이크", 20000, 5000, 50000));
            allMonsterLists.add(new Monsters(21, "죽음의 군주", 1000000, 200000, 1000000));
            allMonsterLists.add(new Monsters(9999, "하이퍼 메탈 슬라임", 1000, 5000000, 10000000));
        }
    }
    @PostMapping("/default-monsters")
    public List<Monsters> addDefaultMonsters() {
        log.info("addDefaultMonsters()");

        currentMonsters.add(new Monsters(1, "슬라임", 50, 10, 5));
        currentMonsters.add(new Monsters(2, "고블린", 100, 20, 10));
        currentMonsters.add(new Monsters(3, "놀", 200, 40, 20));

        return currentMonsters;
    }

    @PostMapping("/many-monsters")
    public List<Monsters> addManyMonsters() {
        log.info("addManyMonsters()");

        createdMonsters = new ArrayList<>();
        buildDefaultMonsterList();

        for (int i = 0; i < 100; i++) {
            createdMonsters.add(addMonster());
        }
        for (int i = 0; i < createdMonsters.size(); i++) {
            currentMonsters.add(createdMonsters.get(i));
        }
        return currentMonsters;
    }

    public Monsters addMonster() {
        buildDefaultMonsterList();
        int everyMonsterSize = allMonsterLists.size();
        Monsters monster;
        monster = allMonsterLists.get(CustomRandom.makeIntCustomRandom(0, everyMonsterSize - 1));

        return monster;
    }

}
