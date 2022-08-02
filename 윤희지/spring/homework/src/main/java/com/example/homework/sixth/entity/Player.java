package com.example.homework.sixth.entity;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {
    private String name;
    private Score score;

    public Player(String name) {
        this.name = name;
        score = new Score();
    }
}
