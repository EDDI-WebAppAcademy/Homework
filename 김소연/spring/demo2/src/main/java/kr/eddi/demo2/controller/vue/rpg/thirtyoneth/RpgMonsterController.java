package kr.eddi.demo2.controller.vue.rpg.thirtyoneth;

import kr.eddi.demo2.entity.vue.rpg.Monsters;
import kr.eddi.demo2.utility.basic.third.CustomRandom;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/31th/rpg-game")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class RpgMonsterController {
    /*
    * monsterBooks: [ //몬스터 관리 도감 필요
        {monsterId: 1, name: '슬라임', hp: 50, exp: 10, dropMoney: 5},
        {monsterId: 2, name: '고블린', hp: 100, exp: 20, dropMoney: 10},
        {monsterId: 3, name: '놀', hp: 200, exp: 40, dropMoney: 20},
        {monsterId: 4, name: '멧돼지', hp: 400, exp: 100, dropMoney: 20},
        {monsterId: 5, name: '스켈레톤', hp: 350, exp: 90, dropMoney: 10},
        {monsterId: 6, name: '오크', hp: 550, exp: 150, dropMoney: 40},
        {monsterId: 7, name: '홉고블린', hp: 650, exp: 180, dropMoney: 50},
        {monsterId: 8, name: '스켈레톤 아처', hp: 300, exp: 150, dropMoney: 50},
        {monsterId: 9, name: '트롤', hp: 800, exp: 200, dropMoney: 80},
        {monsterId: 10, name: '좀비', hp: 350, exp: 90, dropMoney: 50},
        {monsterId: 11, name: '고블린 매지션', hp: 700, exp: 500, dropMoney: 300},
        {monsterId: 12, name: '오우거', hp: 1000, exp: 250, dropMoney: 50},
        {monsterId: 13, name: '고스트', hp: 750, exp: 300, dropMoney: 1},
        {monsterId: 14, name: '골렘', hp: 2000, exp: 400, dropMoney: 100},
        {monsterId: 15, name: '와이번', hp: 3500, exp: 500, dropMoney: 150},
        {monsterId: 16, name: '리치', hp: 2000, exp: 1000, dropMoney: 500},
        {monsterId: 17, name: '스켈레톤 기사', hp: 2500, exp: 700, dropMoney: 100},
        {monsterId: 18, name: '웨어울프', hp: 5000, exp: 1000, dropMoney: 700},
        {monsterId: 19, name: '미노타우루스', hp: 10000, exp: 1500, dropMoney: 1000},
        {monsterId: 20, name: '드레이크', hp: 20000, exp: 5000, dropMoney: 50000},
        {monsterId: 21, name: '죽음의 군주', hp: 1000000, exp: 200000, dropMoney: 1000000},
        {monsterId: 21, name: '하이퍼 메탈 슬라임', hp: 1000, exp: 5000000, dropMoney: 10000000},
    * */
    List<Monsters> allMonsterLists = new ArrayList<>();

    public void buildDefaultMonsterList () {
        if (allMonsterLists.size() == 0) {
            allMonsterLists.add(new Monsters("슬라임", 50, 10, 5));
            allMonsterLists.add(new Monsters("고블린", 100, 20, 10));
            allMonsterLists.add(new Monsters("놀", 200, 40, 20));
            allMonsterLists.add(new Monsters("멧돼지", 400, 100, 20));
            allMonsterLists.add(new Monsters("스켈레톤", 350, 90, 10));
            allMonsterLists.add(new Monsters("오크", 550, 150, 40));
            allMonsterLists.add(new Monsters("홉고블린", 650, 180, 50));
            allMonsterLists.add(new Monsters("스켈레톤 아처",  300, 150, 50));
            allMonsterLists.add(new Monsters("트롤", 800, 200, 80));
            allMonsterLists.add(new Monsters("좀비", 350, 90, 50));
            allMonsterLists.add(new Monsters("고블린 매지션", 700, 500, 300));
            allMonsterLists.add(new Monsters("오우거", 1000, 250, 50));
            allMonsterLists.add(new Monsters("고스트", 750, 300, 1));
            allMonsterLists.add(new Monsters("골렘",  2000, 400, 100));
            allMonsterLists.add(new Monsters("와이번", 3500, 500, 150));
            allMonsterLists.add(new Monsters("리치", 2000, 1000, 500));
            allMonsterLists.add(new Monsters("스켈레톤 기사", 2500, 700, 100));
            allMonsterLists.add(new Monsters("웨어울프", 5000, 1000, 700));
            allMonsterLists.add(new Monsters("미노타우루스", 10000, 1500, 1000));
            allMonsterLists.add(new Monsters("드레이크", 20000, 5000, 50000));
            allMonsterLists.add(new Monsters("죽음의 군주", 1000000, 200000, 1000000));
            allMonsterLists.add(new Monsters("하이퍼 메탈 슬라임", 1000, 5000000, 10000000));

        }
    }

    public void buildRandomMonsterList (List<Monsters> randomMonsterLists) {
        int everyMonsterSize = allMonsterLists.size();

        for (int i = 0; i < 100; i++) {
            Monsters oneThing = allMonsterLists.get(CustomRandom.makeIntCustomRandom(0,everyMonsterSize -1));
            randomMonsterLists.add(oneThing);
        }
    }


    @GetMapping("/random-monster-lists")
    public List<Monsters> randomMonsterLists() {
        log.info("randomMonsterLists()");

        buildDefaultMonsterList();
        List<Monsters> randomMonsterLists = new ArrayList<>();
        buildRandomMonsterList(randomMonsterLists);

        return randomMonsterLists;
    }
}
