package kr.eddi.demo.entity.vue.thirthyoneth.Monster;



import kr.eddi.demo.utility.fourth.CustomRandomNumber;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class MonsterManager {



    private List<Monster> monstersDataBase;
    private List<Monster> randomMonstersList;

    private int totalMonsterListSize;


    public MonsterManager() {
        monstersDataBase = new ArrayList<>();
        randomMonstersList = new ArrayList<>();
        buildBasicMonsterDataBase();
    }

    /**
     * 기본적인 몬스터 데이터베이스 작성
     */
    public void buildBasicMonsterDataBase() {
        monstersDataBase.add(new Monster(MonsterBook.SLIME.getName(), MonsterBook.SLIME.getHp(), MonsterBook.SLIME.getExp(), MonsterBook.SLIME.getDropMoney()));
        monstersDataBase.add(new Monster(MonsterBook.GOBLIN.getName(),MonsterBook.GOBLIN.getHp(), MonsterBook.GOBLIN.getExp(), MonsterBook.GOBLIN.getDropMoney()));
        monstersDataBase.add(new Monster(MonsterBook.NOB.getName(), MonsterBook.NOB.getHp(), MonsterBook.NOB.getExp(), MonsterBook.NOB.getDropMoney()));
        monstersDataBase.add(new Monster(MonsterBook.WILD_BOAR.getName(),MonsterBook.WILD_BOAR.getHp(), MonsterBook.WILD_BOAR.getExp(), MonsterBook.WILD_BOAR.getDropMoney()));
        monstersDataBase.add(new Monster(MonsterBook.SKELETON.getName(), MonsterBook.SKELETON.getHp(), MonsterBook.SKELETON.getExp(), MonsterBook.SKELETON.getDropMoney()));
        monstersDataBase.add(new Monster(MonsterBook.ORCS.getName(), MonsterBook.ORCS.getHp(), MonsterBook.ORCS.getExp(), MonsterBook.ORCS.getDropMoney()));

        totalMonsterListSize = monstersDataBase.size();
    }


    /**
     * 랜덤한 몬스터 정보를 가져와 리스트에 추가
     */
    public void buildRandomMonster() {
        int randomMonsterNumber = CustomRandomNumber.randomNum(0, totalMonsterListSize-1);
        Monster oneMonster = monstersDataBase.get(randomMonsterNumber);
        randomMonstersList.add(oneMonster);
    }

    /**
     * 랜덤한 몬스터 정보를 받은 횟수만큼 추가
     * @param monsterNums 넣을 개수
     */
    public void buildRandomMonsterList(int monsterNums) {
        for (int i = 0; i < monsterNums; i++) {
            buildRandomMonster();
        }
    }
}
