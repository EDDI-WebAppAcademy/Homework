package lbk.homework.day0903.makeGameAlone.controller.manager;

import lbk.homework.day0903.makeGameAlone.entity.monster.Monsters;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

import static lbk.homework.day0727.secondDiceGame.utility.CustomRandom.makeCustomRandom;

@Getter
public class MonsterManager {
    private List<Object> monsterList;
    private Monsters monsters;

    public MonsterManager() {
        monsterList = new ArrayList<>();
        monsters = new Monsters();
    }

    public List createNewMonster() {
        monsterList.add(acquireRandomMonster());
        return monsterList;
    }

    public Object acquireRandomMonster () {
        int size = monsters.getMonsterBook().size();
        return monsters.getMonsterBook().get(makeCustomRandom( size, 0));
    }
}
