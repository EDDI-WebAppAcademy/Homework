package com.example.homework.first.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiceController {

    @GetMapping("/homework1")
    public int rollDice() {
            return (int) (Math.random()*6) + 1;
    }
}
