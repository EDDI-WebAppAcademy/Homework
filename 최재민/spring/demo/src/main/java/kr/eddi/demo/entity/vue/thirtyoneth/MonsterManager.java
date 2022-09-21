package kr.eddi.demo.entity.vue.thirtyoneth;

import kr.eddi.demo.utility.basic.third.CustomRandom;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class MonsterManager {
    private List<Monsters> addHundredMonstersList = new ArrayList<>();
    private List<Monsters> addDefaultMonsterList = new ArrayList<>();
    private List<Monsters> allMonstersList = new ArrayList<>();

    private final Integer addMonsterCnt = 100;
    public void buildDefaultMonsters(){
        allMonstersList.add(new Monsters(1,"슬라임",50,10,5));
        allMonstersList.add(new Monsters(2,"고블린",100,20,10));
        allMonstersList.add(new Monsters(3,"놀",200,40,20));
        allMonstersList.add(new Monsters(4,"멧돼지",400,100,20));
        allMonstersList.add(new Monsters(5,"스켈레톤",350,90,10));
        allMonstersList.add(new Monsters(6,"오크",550,150,40));
        allMonstersList.add(new Monsters(7,"홉고블린",650,180,50));
        allMonstersList.add(new Monsters(8,"스켈레톤 아처",300,150,50));
        allMonstersList.add(new Monsters(9,"트롤",800,200,80));
        allMonstersList.add(new Monsters(10,"좀비",350,90,50));
        allMonstersList.add(new Monsters(11,"고블린 메지션",700,500,300));
        allMonstersList.add(new Monsters(12,"오우거",1000,250,50));
        allMonstersList.add(new Monsters(13,"고스트",750,300,1));
        allMonstersList.add(new Monsters(14,"골렘",2000,400,100));
        allMonstersList.add(new Monsters(15,"와이번",3500,500,150));
        allMonstersList.add(new Monsters(16,"리치",2000,1000,500));
        allMonstersList.add(new Monsters(17,"스켈레톤 기사",2500,700,100));
        allMonstersList.add(new Monsters(18,"웨어울프",5000,1000,700));
        allMonstersList.add(new Monsters(19,"미노타우루스",10000,1500,1000));
        allMonstersList.add(new Monsters(20,"드레이크",20000,5000,50000));
        allMonstersList.add(new Monsters(21,"죽음의 군주",1000000,200000,1000000));
        allMonstersList.add(new Monsters(9999,"하이퍼 메탈 슬라임",5000000,10,10000000));
    }

    public List<Monsters> addDefaultMonsters(){
        buildDefaultMonsters();
        if(addDefaultMonsterList.size() == 0){
            addDefaultMonsterList.add(allMonstersList.get(0));
            addDefaultMonsterList.add(allMonstersList.get(1));
            addDefaultMonsterList.add(allMonstersList.get(2));
        }


        return addDefaultMonsterList;
    }

    public void buildHundredMonsters(List<Monsters> randomMonsterList){
        buildDefaultMonsters();
        int allMonsterSize = allMonstersList.size();

        for (int i = 0; i < addMonsterCnt; i++) {
            Monsters RanOneMonster = allMonstersList.get(CustomRandom.makeIntCustomRandom(0, allMonsterSize));
            randomMonsterList.add(RanOneMonster);
        }

    }

    public List<Monsters> addHundredMonsters(){
        buildDefaultMonsters();
        buildHundredMonsters(addHundredMonstersList);

        return addHundredMonstersList;
    }
}
