package kr.eddi.demo.controller.vue.rpg.thirtyoneth;

import kr.eddi.demo.entity.vue.rpg.MonsterBook;
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
@RequestMapping("/31th/rpg-game")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class RpgMonsterController {

    private List<MonsterBook> allMonsterList = new ArrayList<>();

    public void buildDefaultMonsterLists () {
        if(allMonsterList.size() ==  0){
            allMonsterList.add(new MonsterBook(1,"슬라임",50,10,5));
            allMonsterList.add(new MonsterBook(2,"고블린",100,20,10));
            allMonsterList.add(new MonsterBook(3,"놀",200,40,20));
            allMonsterList.add(new MonsterBook(4,"멧돼지",400,100,20));
            allMonsterList.add(new MonsterBook(5,"스켈레톤",350,90,10));
            allMonsterList.add(new MonsterBook(6,"오크",550,150,40));
            allMonsterList.add(new MonsterBook(7,"홉고블린",650,180,50));
            allMonsterList.add(new MonsterBook(8,"스켈레톤 아처",300,150,50));
            allMonsterList.add(new MonsterBook(9,"트롤",800,200,80));
            allMonsterList.add(new MonsterBook(10,"좀비",350,90,50));
            allMonsterList.add(new MonsterBook(11,"고블린 매지션",700,500,300));
            allMonsterList.add(new MonsterBook(12,"오우거",1000,250,50));
            allMonsterList.add(new MonsterBook(13,"고스트",750,300,1));
            allMonsterList.add(new MonsterBook(14,"골렘",2000,400,100));
            allMonsterList.add(new MonsterBook(15,"와이번",3500,500,150));
            allMonsterList.add(new MonsterBook(16,"리치",2000,1000,500));
            allMonsterList.add(new MonsterBook(17,"스켈레톤 기사",2500,700,100));
            allMonsterList.add(new MonsterBook(18,"웨어울프",5000,1000,700));
            allMonsterList.add(new MonsterBook(19,"미노타우루스",10000,1500,1000));
            allMonsterList.add(new MonsterBook(20,"드레이크",20000,5000,50000));
            allMonsterList.add(new MonsterBook(21,"죽음의 군주",1000000,200000,1000000));
            allMonsterList.add(new MonsterBook(9999,"하이퍼 메탈 슬라임",1000,5000000,100000000));
        }
    }

    public void buildRandomMonsterLists (List<MonsterBook> randomMonsterLists) {
        int everyMonsterSize = allMonsterList.size();

        for (int i = 0; i < 100; i++) {
            MonsterBook oneThing = allMonsterList.get(
                        CustomRandom.makeIntCustomRandom(0 , everyMonsterSize - 1));
            randomMonsterLists.add(oneThing);
        }
    }




    @GetMapping("/add-many-random-monster-lists")
    public List<MonsterBook> addManyRandomMonsterLists () {

        log.info("addManyRandomMonsterLists()");

        buildDefaultMonsterLists();
        List<MonsterBook> randomMonsterLists = new ArrayList<>();
        buildRandomMonsterLists(randomMonsterLists);

        return randomMonsterLists;
    }
}
