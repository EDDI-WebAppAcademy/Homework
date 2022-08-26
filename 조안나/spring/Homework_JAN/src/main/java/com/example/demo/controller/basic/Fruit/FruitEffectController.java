package com.example.demo.controller.basic.Fruit;

import com.example.demo.entity.basic.fruit.FruitGameManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/fruit")
public class FruitEffectController {
    FruitGameManager fruitGameManager;
    private final int PLAYER_NUM = 1;

    @GetMapping("/game-start")
    public String FruitGameStart() {
        fruitGameManager = new FruitGameManager();
        fruitGameManager.GameStart(PLAYER_NUM);

        return "test중~";
    }
}
