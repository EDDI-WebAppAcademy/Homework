package study.Project.controller.vue.rpgGame.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
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

    private CharacterManager characterManager = new CharacterManager();

    @PostMapping("/setting-character-status")
    public CharacterManager requestSettingCharacterStatus() {
        log.info("requestSettingCharacterStatus()");


        return characterManager;
    }
}
