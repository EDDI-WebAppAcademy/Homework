package com.example.homework.second.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClassAverage {
    private int score;
    private double average;

    public int randomScore() {
        for (int i = 0; i < 30; i++) {
            score += (int)(Math.random()*41 + 60);
        }
        return score;
    }

    public double calAvg() {
        average = score/30;
        return average;
    }
}
