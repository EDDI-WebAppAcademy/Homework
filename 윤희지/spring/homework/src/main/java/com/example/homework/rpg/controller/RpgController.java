package com.example.homework.rpg.controller;

import com.example.homework.pokergames.try2.entity.RpgCharacter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/rpg")

public class RpgController {

    public RpgCharacter showCharacterStatus() {
        return null;
    }
}
