package com.example.demo.utillity.basic;

import java.util.Random;

public class CustomRandom {

    public static int makeIntCustomRandom(int MIN, int MAX){
        Random random = new Random();

        return random.nextInt(MIN, MAX+1);
    }
}
