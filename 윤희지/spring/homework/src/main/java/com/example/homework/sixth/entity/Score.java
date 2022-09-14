package com.example.homework.sixth.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Score {
    private int score;

    public Score() {
        score = 0;
    }

    public void gainScore(int num) {
        score += num;
    }

    public void looseScore(int num) {
        score -= num;
        if(score < 0) {
            score = 0;
        }
    }
}
