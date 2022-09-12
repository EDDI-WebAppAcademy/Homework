package kr.eddi.demo.controller.vue.rpg.thirtyoneth;

import kr.eddi.demo.entity.vue.rpg.Character;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/31th/rpg-game3")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class RpgCharacterController {

    @PostMapping("/character-status")
    public Character characterStatus() {
        log.info("characterStatus()");
        Character character = new Character(1,50,30,0,10,10,
                10,10,10,10,10,0,10,0,0,"모험가");


        return character;
    }
}
