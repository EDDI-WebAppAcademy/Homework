package kr.eddi.demo.controller.vue.thirtyoneth;

import kr.eddi.demo.entity.vue.thirtyoneth.CharacterStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/31th/rpg-game")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class RpgCharacterController {

    public static CharacterStatus characterStatus = new CharacterStatus();

    @PostMapping("/get-character-status")
    public CharacterStatus requestCharacterStatus () {
        log.info("requestCharacterStatus()");

        return characterStatus;
    }
}
