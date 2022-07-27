package com.example.homework.javapractice.Controller;

import com.example.homework.javapractice.Entity.DiceGame;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/dice-game")
public class DiceGameRestController {

    @GetMapping("/")
    public String playDiceGame() {
        DiceGame dGame = new DiceGame(4);
        dGame.playGame();

        return null;
    }
}
