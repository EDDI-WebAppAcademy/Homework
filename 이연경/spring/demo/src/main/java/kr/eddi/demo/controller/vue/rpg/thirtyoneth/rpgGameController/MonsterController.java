package kr.eddi.demo.controller.vue.rpg.thirtyoneth.rpgGameController;


import kr.eddi.demo.entity.vue.rpg.Monster;

import kr.eddi.demo.utilty.basic.third.CustomRandom;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/31th/rpg-game-controller")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")


public class MonsterController {


    private List<Monster> monsterBook = new ArrayList<>();

    public void MonsterList() {
        monsterBook.add(new Monster("슬라임", 50, 10, 5));
        monsterBook.add(new Monster("고블린", 100, 20, 10));
        monsterBook.add(new Monster("놀", 200, 40, 20));
        monsterBook.add(new Monster("멧돼지", 400, 100, 20));
        monsterBook.add(new Monster("스켈레톤", 350, 90, 10));
        monsterBook.add(new Monster("오크", 550, 150, 40));
        monsterBook.add(new Monster("홉고블린", 650, 180, 50));
        monsterBook.add(new Monster("스켈레톤 아처", 300, 150, 50));
        monsterBook.add(new Monster("트롤", 800, 200, 80));
        monsterBook.add(new Monster("좀비", 350, 90, 50));
        monsterBook.add(new Monster("고블린 매지션", 700, 500, 300));
        monsterBook.add(new Monster("오우거", 1000, 250, 50));
        monsterBook.add(new Monster("고스트", 750, 300, 1));
        monsterBook.add(new Monster("골렘", 2000, 400, 100));
        monsterBook.add(new Monster("와이번", 3500, 500, 150));
        monsterBook.add(new Monster("리치", 2000, 1000, 500));
        monsterBook.add(new Monster("스켈레톤 기사", 2500, 700, 100));
        monsterBook.add(new Monster("웨어울프", 5000, 1000, 700));
        monsterBook.add(new Monster("미노타우루스", 10000, 1500, 1000));
        monsterBook.add(new Monster("드레이크", 20000, 5000, 50000));
        monsterBook.add(new Monster("죽음의 군주", 1000000, 200000, 1000000));
        monsterBook.add(new Monster("하이퍼 메탈 슬라임", 1000, 5000000, 10000000));
    }

    public void randomMonsterList(List<Monster> randomMonsterList) {
        int everyMonsterSize = monsterBook.size();

        for (int i = 0; i < 100; i++) {
            Monster list = monsterBook.get(CustomRandom.makeIntCustomRandom(0, everyMonsterSize-1));
            randomMonsterList.add(list);
        }
    }

    public List<Monster> createRandomMonster() {
        log.info("createRandomMonster()");

        MonsterList();
        List<Monster> randomMonsterList = new ArrayList<>();
        randomMonsterList(randomMonsterList);

        return randomMonsterList;
    }





}
