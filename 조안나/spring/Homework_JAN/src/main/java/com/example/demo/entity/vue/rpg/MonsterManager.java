package com.example.demo.entity.vue.rpg;

import com.example.demo.utillity.basic.CustomRandom;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class MonsterManager {

    List<Monster> buildDefaultMonsterList = new ArrayList<>();
    private final int ADD_MONSTER_NUMBER = 100;

    public MonsterManager() {
    }
    /**
     * 모든 몬스터 List에 추가하기
     */
    public void buildDefaultMonsterList(){
        buildDefaultMonsterList.add(new Monster(Monster.MonsterBooks.SLIME.getName(), Monster.MonsterBooks.SLIME.getHp()));
        buildDefaultMonsterList.add(new Monster(Monster.MonsterBooks.GOBLIN.getName(), Monster.MonsterBooks.GOBLIN.getHp()));
        buildDefaultMonsterList.add(new Monster(Monster.MonsterBooks.NOLL.getName(), Monster.MonsterBooks.NOLL.getHp()));
        buildDefaultMonsterList.add(new Monster(Monster.MonsterBooks.BOAR.getName(), Monster.MonsterBooks.BOAR.getHp()));
        buildDefaultMonsterList.add(new Monster(Monster.MonsterBooks.SKELETON.getName(), Monster.MonsterBooks.SKELETON.getHp()));
        buildDefaultMonsterList.add(new Monster(Monster.MonsterBooks.ORC.getName(), Monster.MonsterBooks.ORC.getHp()));
        buildDefaultMonsterList.add(new Monster(Monster.MonsterBooks.HOBGOBLIN.getName(), Monster.MonsterBooks.HOBGOBLIN.getHp()));
        buildDefaultMonsterList.add(new Monster(Monster.MonsterBooks.SKELETON_ARCHER.getName(), Monster.MonsterBooks.SKELETON_ARCHER.getHp()));
        buildDefaultMonsterList.add(new Monster(Monster.MonsterBooks.TROLL.getName(), Monster.MonsterBooks.TROLL.getHp()));
        buildDefaultMonsterList.add(new Monster(Monster.MonsterBooks.ZOMBIE.getName(), Monster.MonsterBooks.ZOMBIE.getHp()));
        buildDefaultMonsterList.add(new Monster(Monster.MonsterBooks.GOBLIN_MAGICIAN.getName(), Monster.MonsterBooks.GOBLIN_MAGICIAN.getHp()));
        buildDefaultMonsterList.add(new Monster(Monster.MonsterBooks.OGRE.getName(), Monster.MonsterBooks.OGRE.getHp()));
        buildDefaultMonsterList.add(new Monster(Monster.MonsterBooks.GHOST.getName(), Monster.MonsterBooks.GHOST.getHp()));
        buildDefaultMonsterList.add(new Monster(Monster.MonsterBooks.GOLEM.getName(), Monster.MonsterBooks.GOLEM.getHp()));
        buildDefaultMonsterList.add(new Monster(Monster.MonsterBooks.WYVERN.getName(), Monster.MonsterBooks.WYVERN.getHp()));
        buildDefaultMonsterList.add(new Monster(Monster.MonsterBooks.SKELETON_KNIGHT.getName(), Monster.MonsterBooks.SKELETON_KNIGHT.getHp()));
        buildDefaultMonsterList.add(new Monster(Monster.MonsterBooks.WEARWOLF.getName(), Monster.MonsterBooks.WEARWOLF.getHp()));
        buildDefaultMonsterList.add(new Monster(Monster.MonsterBooks.MINOTAURUS.getName(), Monster.MonsterBooks.MINOTAURUS.getHp()));
        buildDefaultMonsterList.add(new Monster(Monster.MonsterBooks.DRAKE.getName(), Monster.MonsterBooks.DRAKE.getHp()));
        buildDefaultMonsterList.add(new Monster(Monster.MonsterBooks.LORD_OF_THE_DEAD.getName(), Monster.MonsterBooks.LORD_OF_THE_DEAD.getHp()));
        buildDefaultMonsterList.add(new Monster(Monster.MonsterBooks.HYPERMETAL_SLIME.getName(), Monster.MonsterBooks.HYPERMETAL_SLIME.getHp()));
    }

    /**
     * 몬스터 ADD_MONSTER_NUMBER 마리 추가
     * @param monsterLists 생성된 몬스터 담을 List
     */
    public void addManyRandomMonster( List<Monster> monsterLists) {
        for (int i = 0; i < ADD_MONSTER_NUMBER; i++) {
            addRandomMonster(monsterLists);
        }
    }

    /**
     * 랜덤한 몬스터 하나를 리스트에 추가
     * @param monsterLists 생성된 몬스터 담을 List
     */
    public void addRandomMonster(List<Monster> monsterLists) {
        int buildDefaultMonsterListSize = buildDefaultMonsterList.size();
        int randomMonsterBookIdx = CustomRandom.makeIntCustomRandom(0, buildDefaultMonsterListSize - 1);
        monsterLists.add(buildDefaultMonsterList.get(randomMonsterBookIdx));
    }
}

