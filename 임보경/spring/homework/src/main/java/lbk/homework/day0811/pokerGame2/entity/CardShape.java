package lbk.homework.day0811.pokerGame2.entity;

import lombok.Getter;

@Getter
public enum CardShape {
    SPADE("SPADE", 4),
    DIA("DIA", 3),
    HEART("HEART", 2),
    CLOVER("CLOVER", 1);

    private final String name;
    private final int value;

    private CardShape(String name, int value) {
        this.name = name;
        this.value = value;
    }
}
