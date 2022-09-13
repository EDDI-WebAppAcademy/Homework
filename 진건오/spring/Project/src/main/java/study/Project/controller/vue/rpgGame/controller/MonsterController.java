package study.Project.controller.vue.rpgGame.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.Project.entity.vue.rpgGame.MonsterBooks;
import study.Project.entity.vue.rpgGame.MonsterManager;
import study.Project.utility.basic.third.CustomRandom;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/monster")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class MonsterController {

    private List<MonsterManager> monsterLists = new ArrayList<>();

    public void createMonsterList() {
        if (monsterLists.size() == 0) {
            monsterLists.add(new MonsterManager(MonsterBooks.SLIME.getMONSTER_NAME(),MonsterBooks.SLIME.getMONSTER_HP()));
            monsterLists.add(new MonsterManager(MonsterBooks.GOBLIN.getMONSTER_NAME(),MonsterBooks.GOBLIN.getMONSTER_HP()));
            monsterLists.add(new MonsterManager(MonsterBooks.GNOLL.getMONSTER_NAME(),MonsterBooks.GNOLL.getMONSTER_HP()));
            monsterLists.add(new MonsterManager(MonsterBooks.WILD_BOAR.getMONSTER_NAME(),MonsterBooks.WILD_BOAR.getMONSTER_HP()));
            monsterLists.add(new MonsterManager(MonsterBooks.SKELETON.getMONSTER_NAME(),MonsterBooks.SKELETON.getMONSTER_HP()));
            monsterLists.add(new MonsterManager(MonsterBooks.OAK.getMONSTER_NAME(),MonsterBooks.OAK.getMONSTER_HP()));
            monsterLists.add(new MonsterManager(MonsterBooks.HOB_GOBLIN.getMONSTER_NAME(),MonsterBooks.HOB_GOBLIN.getMONSTER_HP()));
            monsterLists.add(new MonsterManager(MonsterBooks.SKELETON_ARCHER.getMONSTER_NAME(),MonsterBooks.SKELETON_ARCHER.getMONSTER_HP()));
            monsterLists.add(new MonsterManager(MonsterBooks.TROLL.getMONSTER_NAME(),MonsterBooks.TROLL.getMONSTER_HP()));
            monsterLists.add(new MonsterManager(MonsterBooks.ZOMBIE.getMONSTER_NAME(),MonsterBooks.ZOMBIE.getMONSTER_HP()));
            monsterLists.add(new MonsterManager(MonsterBooks.GOBLIN_MAGICIAN.getMONSTER_NAME(),MonsterBooks.GOBLIN_MAGICIAN.getMONSTER_HP()));
            monsterLists.add(new MonsterManager(MonsterBooks.OGRE.getMONSTER_NAME(),MonsterBooks.OGRE.getMONSTER_HP()));
            monsterLists.add(new MonsterManager(MonsterBooks.GHOST.getMONSTER_NAME(),MonsterBooks.GHOST.getMONSTER_HP()));
            monsterLists.add(new MonsterManager(MonsterBooks.GOLEM.getMONSTER_NAME(),MonsterBooks.GOLEM.getMONSTER_HP()));
            monsterLists.add(new MonsterManager(MonsterBooks.WYVERN.getMONSTER_NAME(),MonsterBooks.WYVERN.getMONSTER_HP()));
            monsterLists.add(new MonsterManager(MonsterBooks.LYCH.getMONSTER_NAME(),MonsterBooks.LYCH.getMONSTER_HP()));
            monsterLists.add(new MonsterManager(MonsterBooks.SKELETON_KNIGHT.getMONSTER_NAME(),MonsterBooks.SKELETON_KNIGHT.getMONSTER_HP()));
            monsterLists.add(new MonsterManager(MonsterBooks.WEREWOLF.getMONSTER_NAME(),MonsterBooks.WEREWOLF.getMONSTER_HP()));
            monsterLists.add(new MonsterManager(MonsterBooks.MINOTAUR.getMONSTER_NAME(),MonsterBooks.MINOTAUR.getMONSTER_HP()));
            monsterLists.add(new MonsterManager(MonsterBooks.DRAKE.getMONSTER_NAME(),MonsterBooks.DRAKE.getMONSTER_HP()));
            monsterLists.add(new MonsterManager(MonsterBooks.LORD_OF_DEATH.getMONSTER_NAME(),MonsterBooks.LORD_OF_DEATH.getMONSTER_HP()));
            monsterLists.add(new MonsterManager(MonsterBooks.HYPER_METAL_SLIME.getMONSTER_NAME(),MonsterBooks.HYPER_METAL_SLIME.getMONSTER_HP()));
        }
    }

    public void randomCreateMultipleMonster(List<MonsterManager> randomCreateManyMonster) {
        int currentMonsterListSize = monsterLists.size();

        for (int i = 0; i < 100; i++) {
            MonsterManager getMonsterListAnything = monsterLists.get(CustomRandom.makIntCustomRandom(0, currentMonsterListSize - 1));
            randomCreateManyMonster.add(getMonsterListAnything);
        }
    }

    @GetMapping("/create-monster")
    public List rpgGameCreateMonsterController() {
        log.info("rpgGameCreateMonsterController()");

        createMonsterList();
        List<MonsterManager> randomCreateManyMonster = new ArrayList<>();
        randomCreateMultipleMonster(randomCreateManyMonster);

        return randomCreateManyMonster;
    }
}
