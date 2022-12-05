package kr.eddi.demo.controller.vue.thirtyfirst;

import kr.eddi.demo.entity.vue.thirtiyfirst.MonsterBooks;
import kr.eddi.demo.utility.basic.third.CustomRandom;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/31st/rpg-game")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class RpgMonsterController {
    private List<MonsterBooks> allMonsterBooks = new ArrayList<>();
    private List<MonsterBooks> randomMonsterList = new ArrayList<>();
    private List<MonsterBooks> monsterList = new ArrayList<>();

    public void buildDefaultMonsterBooks () {
        allMonsterBooks.add(new MonsterBooks(1, "슬라임", 50, 10, 5));
        allMonsterBooks.add(new MonsterBooks(2, "고블린", 100, 20, 10));
        allMonsterBooks.add(new MonsterBooks(3, "놀", 200, 40, 20));
        allMonsterBooks.add(new MonsterBooks(4, "멧돼지", 400, 100, 20));
        allMonsterBooks.add(new MonsterBooks(5, "스켈레톤", 350, 90, 10));
        allMonsterBooks.add(new MonsterBooks(6, "오크", 550, 150, 40));
        allMonsterBooks.add(new MonsterBooks(7, "홉고블린", 650, 180, 50));
        allMonsterBooks.add(new MonsterBooks(8, "스켈레톤 아처", 300, 150, 50));
        allMonsterBooks.add(new MonsterBooks(9, "트롤", 800, 200, 80));
        allMonsterBooks.add(new MonsterBooks(10, "좀비", 350, 90, 50));
        allMonsterBooks.add(new MonsterBooks(11, "고블린 매지션", 700, 500, 300));
        allMonsterBooks.add(new MonsterBooks(12, "오우거", 1000, 250, 50));
        allMonsterBooks.add(new MonsterBooks(13, "고스트", 750, 300, 1));
        allMonsterBooks.add(new MonsterBooks(14, "골렘", 2000, 400, 100));
        allMonsterBooks.add(new MonsterBooks(15, "와이번", 3500, 500, 150));
        allMonsterBooks.add(new MonsterBooks(16, "리치", 2000, 1000, 500));
        allMonsterBooks.add(new MonsterBooks(17, "스켈레톤 기사", 2500, 700, 100));
        allMonsterBooks.add(new MonsterBooks(18, "웨어울프", 5000, 1000, 700));
        allMonsterBooks.add(new MonsterBooks(19, "미노타우루스", 10000, 1500, 1000));
        allMonsterBooks.add(new MonsterBooks(20, "드레이크", 20000, 5000, 50000));
        allMonsterBooks.add(new MonsterBooks(21, "죽음의 군주", 1000000, 200000, 1000000));
        allMonsterBooks.add(new MonsterBooks(9999, "하이퍼 메탈 슬라임", 1000, 5000000, 10000000));
    }

    public void addRandomMonsterList () {
        int everyMonsterSize = allMonsterBooks.size();

            MonsterBooks oneMonster = allMonsterBooks.get(CustomRandom.makeIntCustomRandom(0, everyMonsterSize - 1));
//            randomMonsterLists.add(oneMonster);
        monsterList.add(oneMonster);
    }
    public void buildDefaultMonsterList () {
        for (int i = 0; i < 3; i++) {
            monsterList.add(allMonsterBooks.get(i));
        }
    }

    @GetMapping("/add-random-monster")
    public List<MonsterBooks> addRandomMonster() {
        log.info("addRandomMonster()");

        addRandomMonsterList();

        return monsterList;
    }

    @GetMapping("/view-monster-list")
    public List<MonsterBooks> viewMonsterList() {
        log.info("viewMonsterList()");

        buildDefaultMonsterBooks();
        if (monsterList.size() == 0) {
            buildDefaultMonsterList();
        }

        return monsterList;
    }



}
