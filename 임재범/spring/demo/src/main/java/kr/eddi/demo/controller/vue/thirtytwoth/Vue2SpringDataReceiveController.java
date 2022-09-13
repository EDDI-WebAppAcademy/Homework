package kr.eddi.demo.controller.vue.thirtytwoth;

import kr.eddi.demo.controller.vue.thirtytwoth.request.VueRequestTestData;
import kr.eddi.demo.entity.vue.rpg.CharacterManager;
import kr.eddi.demo.entity.vue.rpg.CharacterStatus;
import kr.eddi.demo.entity.vue.rpg.MonsterManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@RestController
@RequestMapping("/32th/vue2spring")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class Vue2SpringDataReceiveController {
    private List<CharacterManager> characterStatusList = new ArrayList<CharacterManager>();
    private List<MonsterManager> beginnerMonsterList = new ArrayList<MonsterManager>();
    public List getCharacterStatus() {
        if (characterStatusList.size() == 0) {
            characterStatusList.add(new CharacterManager(
                    CharacterStatus.HP.getCHARACTER_STATUS_VALUE(),
                    CharacterStatus.MP.getCHARACTER_STATUS_VALUE(),
                    CharacterStatus.ATK.getCHARACTER_STATUS_VALUE(),
                    CharacterStatus.LEVEL.getCHARACTER_STATUS_VALUE(),
                    CharacterStatus.INTELLIGENCE.getCHARACTER_STATUS_VALUE(),
                    CharacterStatus.STR.getCHARACTER_STATUS_VALUE(),
                    CharacterStatus.DEX.getCHARACTER_STATUS_VALUE(),
                    CharacterStatus.VIT.getCHARACTER_STATUS_VALUE(),
                    CharacterStatus.DEF.getCHARACTER_STATUS_VALUE(),
                    CharacterStatus.MEN.getCHARACTER_STATUS_VALUE(),
                    CharacterStatus.CURRENT_LEVEL_BAR.getCHARACTER_STATUS_VALUE(),
                    CharacterStatus.TOTAL_LEVEL_BAR.getCHARACTER_STATUS_VALUE(),
                    CharacterStatus.MONEY.getCHARACTER_STATUS_VALUE()));
        }
        return characterStatusList;
    }

    public List getBeginnerMonsterLists() {
        if (beginnerMonsterList.size() == 0) {
            beginnerMonsterList.add(
                    new MonsterManager(
                    )
        }
        return beginnerMonsterList;
    }

    @PostMapping("/receive-test")
    public void receiveData (@RequestBody VueRequestTestData vueRequestTestData) {
        log.info("요청된 데이터 정보: " + vueRequestTestData);
    }

    @GetMapping("/get-character-status")
    public List requestGetCharacterStatus() {
        log.info("requestGetCharacterStatus()");

        return getCharacterStatus();
    }

    @GetMapping("/get-Beginner-Monsters")
    public List requestBeginnerMonsters() {
        log.info("requestBeginnerMonsters()");

        return getBeginnerMonsterLists();
    }

}