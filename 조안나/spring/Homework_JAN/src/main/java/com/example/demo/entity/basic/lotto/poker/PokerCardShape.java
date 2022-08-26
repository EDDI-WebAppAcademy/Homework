package com.example.demo.entity.basic.lotto.poker;

import lombok.Getter;

@Getter
public enum PokerCardShape {
    SPADE("스페이드", 1),
    DIAMOND("다이아몬드", 2),
    HEART("하트", 3),
    CLOVER("클로버", 4);

    private final String name;
    private final int value;

    private PokerCardShape(String name, int value) {
        this.name = name;
        this.value = value;
    }
}

