package study.Project.controller.vue.rpgGame.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import study.Project.entity.vue.rpgGame.ExperienceChangeManager;
import study.Project.entity.vue.rpgGame.ExperienceSettingManager;
import study.Project.entity.vue.rpgGame.ExperienceKind;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/experience")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class ExperienceChangeController {

    private List<ExperienceSettingManager> experienceList = new ArrayList<>();
    private static ExperienceChangeManager experienceChangeManager = new ExperienceChangeManager();

    public List settingExperienceValue() {
        if (experienceList.size() == 0) {
            experienceList.add(new ExperienceSettingManager(ExperienceKind.CHANGE_HP.getCHANGE_EXPERIENCE_KIND_NAME()));
            experienceList.add(new ExperienceSettingManager(ExperienceKind.CHANGE_MP.getCHANGE_EXPERIENCE_KIND_NAME()));
            experienceList.add(new ExperienceSettingManager(ExperienceKind.CHANGE_ATK.getCHANGE_EXPERIENCE_KIND_NAME()));
            experienceList.add(new ExperienceSettingManager(ExperienceKind.CHANGE_STR.getCHANGE_EXPERIENCE_KIND_NAME()));
            experienceList.add(new ExperienceSettingManager(ExperienceKind.CHANGE_DEX.getCHANGE_EXPERIENCE_KIND_NAME()));
            experienceList.add(new ExperienceSettingManager(ExperienceKind.CHANGE_INT.getCHANGE_EXPERIENCE_KIND_NAME()));
            experienceList.add(new ExperienceSettingManager(ExperienceKind.CHANGE_DEF.getCHANGE_EXPERIENCE_KIND_NAME()));
        }
        return experienceList;
    }

    @GetMapping("/setting-value")
    public List requestExperienceChange() {
        log.info("requestExperienceChange()");

        return settingExperienceValue();
    }

    @PostMapping("/change")
    public Boolean requestCharacterStatus(@RequestBody ArrayList<Integer> selectedExpChangeLists) {
        log.info("requestCharacterStatus()" + selectedExpChangeLists);

        return experienceChangeManager.experienceChange(selectedExpChangeLists);
    }
}
