package com.example.homework.javapractice.total.exam2;

import lombok.Getter;

@Getter
public enum Scale {
    C("Do"),
    D("Re"),
    E("Mi"),
    F("Fa"),
    G("Sol"),
    A("Ra"),
    B("Si");

    private final String value;

    private Scale(String value) {
        this.value = value;
    }

}


