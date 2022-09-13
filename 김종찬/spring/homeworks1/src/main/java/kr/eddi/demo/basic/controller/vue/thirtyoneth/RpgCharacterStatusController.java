package kr.eddi.demo.basic.controller.vue.thirtyoneth;

import kr.eddi.demo.entity.vue.rpg.CharacterStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/31th/rpg-game")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class RpgCharacterStatusController {

    @GetMapping("/character-status")
    public CharacterStatus characterStatus() {
        log.info("characterStatus()");

        CharacterStatus characterStatus = new CharacterStatus
                (1, 50, 30, 0, 10, 10, 10, 10, 10, 10, 10, 0, 10, 0, 0, "모험가" );


        return characterStatus;
    }

}
