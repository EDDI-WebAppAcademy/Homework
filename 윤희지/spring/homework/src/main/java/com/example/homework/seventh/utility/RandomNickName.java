package com.example.homework.seventh.utility;

import java.util.ArrayList;
import java.util.List;

public class RandomNickName {
    public static void makeRandomNickName(int objNum) {
        List<String> objNickNames = new ArrayList<>();
        for (int i = 0; i < objNum; i++) {
            objNickNames.add(i, "person" + i);
        }
    }

}
