package study.Project.controller.vue.thirtytwoth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import study.Project.controller.vue.thirtytwoth.request.ExperienceTypes;
import study.Project.controller.vue.thirtytwoth.request.RequestBuyItem;
import study.Project.controller.vue.thirtytwoth.request.RequestSelectedExpType;
import study.Project.controller.vue.thirtytwoth.request.VueRequestTestData;
import study.Project.entity.vue.rpgGame.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/32th/vue2spring")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class Vue2SpringDataReceiveController {

    private List<InventoryManager> inventoryList = new ArrayList<>();
    private List<CharacterManager> characterStatusList = new ArrayList<CharacterManager>();
    private List<ExperienceChangeManager> experienceList = new ArrayList<>();
    private ExperienceTypes experienceTypes;


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

    public List settingExperienceValue() {
        if (experienceList.size() == 0) {
            experienceList.add(new ExperienceChangeManager(ExperienceKind.CHANGE_HP.getCHANGE_EXPERIENCE_KIND_NAME()));
            experienceList.add(new ExperienceChangeManager(ExperienceKind.CHANGE_MP.getCHANGE_EXPERIENCE_KIND_NAME()));
            experienceList.add(new ExperienceChangeManager(ExperienceKind.CHANGE_ATK.getCHANGE_EXPERIENCE_KIND_NAME()));
            experienceList.add(new ExperienceChangeManager(ExperienceKind.CHANGE_STR.getCHANGE_EXPERIENCE_KIND_NAME()));
            experienceList.add(new ExperienceChangeManager(ExperienceKind.CHANGE_DEX.getCHANGE_EXPERIENCE_KIND_NAME()));
            experienceList.add(new ExperienceChangeManager(ExperienceKind.CHANGE_INT.getCHANGE_EXPERIENCE_KIND_NAME()));
            experienceList.add(new ExperienceChangeManager(ExperienceKind.CHANGE_DEF.getCHANGE_EXPERIENCE_KIND_NAME()));
        }
        return experienceList;
    }

    @PostMapping("/receive-test")
    public void receiveData(@RequestBody VueRequestTestData vueRequestTestData) {
        log.info("요청된 데이터 정보: " + vueRequestTestData);
    }

    @PostMapping("/buy-item")
    public void buyItems(@RequestBody RequestBuyItem requestBuyItem) {
        log.info("buyItems()" + requestBuyItem);
        for (int i = 0; i < requestBuyItem.getItemLists().size(); i++) {

            inventoryList.add(new InventoryManager(requestBuyItem.getItemLists().get(i)));
        }
    }

    @GetMapping("/setting-inventory")
    public List requestAddInventory() {
        log.info("requestAddInventory" + inventoryList);
        return inventoryList;
    }

    @GetMapping("/setting-character-status")
    public List requestSettingCharacterStatus() {
        log.info("requestSettingCharacterStatus()");


        return settingCharacterStatus();
    }

    @GetMapping("/experience-change")
    public List requestExperienceChange() {
        log.info("requestExperienceChange()");

        return settingExperienceValue();
    }

    @PostMapping("/receive-change-Exp-Types")
    public void selectedChangeExperienceTypes(@RequestBody RequestSelectedExpType requestSelectedExpType) {
        log.info("selectedChangeExperienceTypes()" + requestSelectedExpType);

        for (int i = 0; i < requestSelectedExpType.getExperienceType().size(); i++) {
            requestSelectedExpType.getExperienceType().get(i).getName();
        }
    }
}
