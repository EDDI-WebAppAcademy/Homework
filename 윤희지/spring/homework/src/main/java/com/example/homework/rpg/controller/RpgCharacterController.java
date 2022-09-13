package com.example.homework.rpg.controller;

import com.example.homework.rpg.entity.RpgCharacter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")

@Slf4j
@RestController
@RequestMapping("/31th/rpg-game")

public class RpgCharacterController {
    static RpgCharacter character =
            new RpgCharacter(1, 50, 50, 30, 30, 0,
                    10, 10, 10, 10, 10, 10, 0,
                    10, 0, 0, "모험가");

    @GetMapping("/character-status")
    public RpgCharacter sendCharacterStatusData() {
        log.info("sendCharacterStatusData()");

        return character;
    }
}
