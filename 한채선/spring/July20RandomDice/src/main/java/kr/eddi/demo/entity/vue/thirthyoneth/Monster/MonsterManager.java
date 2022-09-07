package kr.eddi.demo.entity.vue.thirthyoneth.Monster;



import kr.eddi.demo.utility.fourth.CustomRandomNumber;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class MonsterManager {



    private List<Monster> monstersDataBase;
    private List<Monster> randomMonstersList;

    private int totalMonsterDBSize;


    public MonsterManager() {
        monstersDataBase = new ArrayList<>();
        randomMonstersList = new ArrayList<>();
        buildMonsterDataBase();
    }

    /**
     * 기본적인 몬스터 데이터베이스 작성
     */
    public void buildMonsterDataBase() {
        // 1
        monstersDataBase.add(new Monster(MonsterBook.SLIME.getName(), MonsterBook.SLIME.getHp(), MonsterBook.SLIME.getExp(), MonsterBook.SLIME.getDropMoney()));
        // 2
        monstersDataBase.add(new Monster(MonsterBook.GOBLIN.getName(),MonsterBook.GOBLIN.getHp(), MonsterBook.GOBLIN.getExp(), MonsterBook.GOBLIN.getDropMoney()));
        // 3
        monstersDataBase.add(new Monster(MonsterBook.NOB.getName(), MonsterBook.NOB.getHp(), MonsterBook.NOB.getExp(), MonsterBook.NOB.getDropMoney()));
        // 4
        monstersDataBase.add(new Monster(MonsterBook.WILD_BOAR.getName(),MonsterBook.WILD_BOAR.getHp(), MonsterBook.WILD_BOAR.getExp(), MonsterBook.WILD_BOAR.getDropMoney()));
        // 5
        monstersDataBase.add(new Monster(MonsterBook.SKELETON.getName(), MonsterBook.SKELETON.getHp(), MonsterBook.SKELETON.getExp(), MonsterBook.SKELETON.getDropMoney()));
        // 6
        monstersDataBase.add(new Monster(MonsterBook.ORCS.getName(), MonsterBook.ORCS.getHp(), MonsterBook.ORCS.getExp(), MonsterBook.ORCS.getDropMoney()));
        // 7
        monstersDataBase.add(new Monster(MonsterBook.HOB_GOBLIN.getName(), MonsterBook.HOB_GOBLIN.getHp(), MonsterBook.HOB_GOBLIN.getExp(), MonsterBook.HOB_GOBLIN.getDropMoney()));
        // 8
        monstersDataBase.add(new Monster(MonsterBook.SKELETON_ARCHER.getName(),MonsterBook.SKELETON_ARCHER.getHp(), MonsterBook.SKELETON_ARCHER.getExp(), MonsterBook.SKELETON_ARCHER.getDropMoney()));
        // 9
        monstersDataBase.add(new Monster(MonsterBook.TROLL.getName(),MonsterBook.TROLL.getHp(), MonsterBook.TROLL.getExp(), MonsterBook.TROLL.getDropMoney()));
        // 10
        monstersDataBase.add(new Monster(MonsterBook.ZOMBIE.getName(),MonsterBook.ZOMBIE.getHp(), MonsterBook.ZOMBIE.getExp(), MonsterBook.ZOMBIE.getDropMoney()));
        // 11
        monstersDataBase.add(new Monster(MonsterBook.GOBLIN_MAGICIAN.getName(),MonsterBook.GOBLIN_MAGICIAN.getHp(), MonsterBook.GOBLIN_MAGICIAN.getExp(), MonsterBook.GOBLIN_MAGICIAN.getDropMoney()));
        // 12
        monstersDataBase.add(new Monster(MonsterBook.ORGE.getName(),MonsterBook.ORGE.getHp(), MonsterBook.ORGE.getExp(), MonsterBook.ORGE.getDropMoney()));
        // 13
        monstersDataBase.add(new Monster(MonsterBook.GHOST.getName(),MonsterBook.GHOST.getHp(), MonsterBook.GHOST.getExp(), MonsterBook.GHOST.getDropMoney()));
        // 14
        monstersDataBase.add(new Monster(MonsterBook.GOLEM.getName(),MonsterBook.GOLEM.getHp(), MonsterBook.GOLEM.getExp(), MonsterBook.GOLEM.getDropMoney()));
        // 15
        monstersDataBase.add(new Monster(MonsterBook.WYVERN.getName(),MonsterBook.WYVERN.getHp(), MonsterBook.WYVERN.getExp(), MonsterBook.WYVERN.getDropMoney()));
        // 16
        monstersDataBase.add(new Monster(MonsterBook.LICH.getName(),MonsterBook.LICH.getHp(), MonsterBook.LICH.getExp(), MonsterBook.LICH.getDropMoney()));
        // 17
        monstersDataBase.add(new Monster(MonsterBook.SKELETON_KNIGHT.getName(),MonsterBook.SKELETON_KNIGHT.getHp(), MonsterBook.SKELETON_KNIGHT.getExp(), MonsterBook.SKELETON_KNIGHT.getDropMoney()));
        // 18
        monstersDataBase.add(new Monster(MonsterBook.WERE_WOLF.getName(),MonsterBook.WERE_WOLF.getHp(), MonsterBook.WERE_WOLF.getExp(), MonsterBook.WERE_WOLF.getDropMoney()));
        // 19
        monstersDataBase.add(new Monster(MonsterBook.MINOTAUROS.getName(),MonsterBook.MINOTAUROS.getHp(), MonsterBook.MINOTAUROS.getExp(), MonsterBook.MINOTAUROS.getDropMoney()));
        // 20
        monstersDataBase.add(new Monster(MonsterBook.DRAKE.getName(),MonsterBook.DRAKE.getHp(), MonsterBook.DRAKE.getExp(), MonsterBook.DRAKE.getDropMoney()));
        // 21
        monstersDataBase.add(new Monster(MonsterBook.LORD_OF_DEATH.getName(),MonsterBook.LORD_OF_DEATH.getHp(), MonsterBook.LORD_OF_DEATH.getExp(), MonsterBook.LORD_OF_DEATH.getDropMoney()));
        // 9999
        monstersDataBase.add(new Monster(MonsterBook.HYPER_METAL_SLIME.getName(),MonsterBook.HYPER_METAL_SLIME.getHp(), MonsterBook.HYPER_METAL_SLIME.getExp(), MonsterBook.HYPER_METAL_SLIME.getDropMoney()));
        totalMonsterDBSize = monstersDataBase.size();
    }


    /**
     * 랜덤한 몬스터 정보를 가져와 리스트에 추가
     */
    public void buildRandomMonster() {
        int randomMonsterNumber = CustomRandomNumber.randomNum(0, totalMonsterDBSize -1);
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
