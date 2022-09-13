package study.Project.controller.vue.rpgGame.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.Project.entity.vue.rpgGame.CharacterJob;
import study.Project.entity.vue.rpgGame.CharacterManager;
import study.Project.entity.vue.rpgGame.CharacterStatus;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/character")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class CharacterController {

    private List<CharacterManager> characterStatusList = new ArrayList<CharacterManager>();


    public List settingCharacterStatus() {
        if (characterStatusList.size() == 0) {
            characterStatusList.add(new CharacterManager(CharacterStatus.HP.getCHARACTER_ABILITY_VALUE(),
                    CharacterStatus.MP.getCHARACTER_ABILITY_VALUE(),
                    CharacterStatus.ATK.getCHARACTER_ABILITY_VALUE(),
                    CharacterStatus.INTELLIGENCE.getCHARACTER_ABILITY_VALUE(),
                    CharacterJob.BASIC.getCHARACTER_JOB_NAME(),
                    CharacterStatus.STR.getCHARACTER_ABILITY_VALUE(),
                    CharacterStatus.INTELLIGENCE.getCHARACTER_ABILITY_VALUE(),
                    CharacterStatus.DEX.getCHARACTER_ABILITY_VALUE(),
                    CharacterStatus.VIT.getCHARACTER_ABILITY_VALUE(),
                    CharacterStatus.DEF.getCHARACTER_ABILITY_VALUE(),
                    CharacterStatus.MEN.getCHARACTER_ABILITY_VALUE(),
                    CharacterStatus.CURRENT_LEVEL_BAR.getCHARACTER_ABILITY_VALUE(),
                    CharacterStatus.TOTAL_LEVEL_BAR.getCHARACTER_ABILITY_VALUE(),
                    CharacterStatus.MONEY.getCHARACTER_ABILITY_VALUE()));

        }
        return characterStatusList;
    }

    @GetMapping("/setting-character-status")
    public List requestSettingCharacterStatus() {
        log.info("requestSettingCharacterStatus()");


        return settingCharacterStatus();
    }
}
