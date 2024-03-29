package com.example.homework.javapractice.Entity;

import java.util.Arrays;

public class Gugudan {
    private int danNum;

    public Gugudan(int danNum) {
        this.danNum = danNum;
    }

    public String makeGugudan(int condition) {
        String msg = "";
        final int MIN = 1;
        final int MAX = 9;

        msg += "<h4>" + "=== " + danNum + "단 ===" + "</h4>";
        for (int i = MIN; i <= MAX; i++) {
            msg += danNum + " * " + i + " = " + (danNum * i) + "<br>";
        }

        return msg;
    }
}
