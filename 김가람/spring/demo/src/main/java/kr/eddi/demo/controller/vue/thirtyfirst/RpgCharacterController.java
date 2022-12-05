package kr.eddi.demo.controller.vue.thirtyfirst;

import kr.eddi.demo.entity.vue.thirtiyfirst.CharacterStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/31st/rpg-game")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class RpgCharacterController {

    public static CharacterStatus characterStatus = new CharacterStatus();

    @PostMapping("/character-status")
    public CharacterStatus requestCharacterStatus () {
        log.info("requestCharacterStatus()");

        return characterStatus;
    }


}
