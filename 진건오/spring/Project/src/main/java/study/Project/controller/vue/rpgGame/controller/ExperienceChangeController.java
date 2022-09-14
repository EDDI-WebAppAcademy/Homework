package study.Project.controller.vue.rpgGame.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import study.Project.controller.vue.thirtytwoth.request.ExperienceTypes;
import study.Project.controller.vue.thirtytwoth.request.RequestSelectedExpType;
import study.Project.entity.vue.rpgGame.ExperienceChangeManager;
import study.Project.entity.vue.rpgGame.ExperienceKind;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/changeExp")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class ExperienceChangeController {

    private List<ExperienceChangeManager> experienceList = new ArrayList<>();

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
