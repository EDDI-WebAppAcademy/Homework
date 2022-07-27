package com.example.homework.javapractice.Entity;

import com.example.homework.utility.CustomRandom;
import lombok.Getter;

@Getter
public class Dice {
    private int diceNum;
    final int MIN = 1;
    final int MAX = 6;
    public void rollDice() {
        diceNum = CustomRandom.makeIntCustomRandom(MIN, MAX);
    }
}
