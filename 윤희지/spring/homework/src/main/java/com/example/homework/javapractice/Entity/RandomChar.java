package com.example.homework.javapractice.Entity;

import com.example.homework.utility.CustomRandom;

public class RandomChar {
    private char ranChar;
    private final int MIN = 65;
    private final int MAX = 112;

    public RandomChar() {
        ranChar = (char)CustomRandom.makeIntCustomRandom(MIN, MAX);
    }
    public String findRandomAlphabet(int condition) {
        String alpha = "";

        if(ranChar >= 60 && ranChar <= 90 || ranChar >= 97 && ranChar <= 122 ) {
            alpha = String.valueOf(ranChar);
        }

        return alpha;
    }
}
