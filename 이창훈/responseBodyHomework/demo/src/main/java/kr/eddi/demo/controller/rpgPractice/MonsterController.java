package kr.eddi.demo.controller.rpgPractice;

import kr.eddi.demo.entity.rpgPractice.AllMonsters;
import kr.eddi.demo.utility.fourth.CustomRandom;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/31th/rpg-game")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class MonsterController {
    private List<AllMonsters> allMonstersList = new ArrayList<>();
    private List<AllMonsters> addMonsterList = new ArrayList<>();

    public void buildAllMonster () {
            allMonstersList.add(new AllMonsters(1,"슬라임", 50,10,5));
            allMonstersList.add(new AllMonsters(2,"고블린", 100,20,10));
            allMonstersList.add(new AllMonsters(3,"놀", 200,40,20));
            allMonstersList.add(new AllMonsters(4,"멧돼지", 400,100,20));
            allMonstersList.add(new AllMonsters(5,"스켈레톤", 350,90,10));
            allMonstersList.add(new AllMonsters(6,"오크", 550,150,40));
            allMonstersList.add(new AllMonsters(7,"홉고블린", 650,180,50));
            allMonstersList.add(new AllMonsters(8,"스켈레톤 아처", 300,150,50));
            allMonstersList.add(new AllMonsters(9,"트롤", 800,200,80));
            allMonstersList.add(new AllMonsters(10,"좀비", 350,90,50));
            allMonstersList.add(new AllMonsters(11,"고블린 매지션", 700,500,300));
            allMonstersList.add(new AllMonsters(12,"오우거", 1000,250,50));
            allMonstersList.add(new AllMonsters(13,"고스트", 750,300,1));
            allMonstersList.add(new AllMonsters(14,"골렘", 2000,400,100));
            allMonstersList.add(new AllMonsters(15,"와이번", 3500,500,150));
            allMonstersList.add(new AllMonsters(16,"리치", 2000,1000,500));
            allMonstersList.add(new AllMonsters(17,"스켈레톤 기사", 2500,700,100));
            allMonstersList.add(new AllMonsters(18,"웨어울프", 5000,1000,700));
            allMonstersList.add(new AllMonsters(19,"미노타우루스", 10000,1500,1000));
            allMonstersList.add(new AllMonsters(20,"드레이크", 20000,5000,50000));
            allMonstersList.add(new AllMonsters(21,"죽음의군주", 1000000,200000,1000000));
            allMonstersList.add(new AllMonsters(9999,"하이퍼 메탈 슬라임", 1000,5000000,10000000));
    }

    @PostMapping("/add-hundred-monster")
    public List<AllMonsters> addHundredMonster() {
        log.info("addHundredMonster()");

        return HundredMonster();
    }

    public void buildHundredMonster(List<AllMonsters> monstersList) {
        buildAllMonster();
        int allMonsterListSize = allMonstersList.size();

        for (int i = 0; i < 100; i++) {
            AllMonsters oneMonster = allMonstersList.get(CustomRandom.makeCustomRandom(0,allMonsterListSize -1));
            monstersList.add(oneMonster);
        }
    }

    public List<AllMonsters> HundredMonster() {
        buildAllMonster();
        buildHundredMonster(addMonsterList);

        return addMonsterList;
    }
}
