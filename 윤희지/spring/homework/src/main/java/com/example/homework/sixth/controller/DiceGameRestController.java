package com.example.homework.sixth.controller;

import com.example.homework.sixth.entity.DiceGame;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/dice-game")
public class DiceGameRestController {

    @GetMapping("/start")
    public String playDiceGame() {
        log.info("게임이 시작되었습니다!");

        DiceGame dGame = new DiceGame(4);
        dGame.playGame();

        return dGame.findWinner();
    }
}
