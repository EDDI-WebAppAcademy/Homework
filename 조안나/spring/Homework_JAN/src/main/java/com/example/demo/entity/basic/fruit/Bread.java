package com.example.demo.entity.basic.fruit;

import java.util.LinkedList;
import java.util.Map;

public class Bread {
    public Bread() {
    }

    /**
     * 빵을 먹었을 때 발동되는 효과 <br>
     * 레벨이 +1 증가한다.
     */
    public void itemEffect(Map<String, LinkedList<Map<String, Integer>>> characterPubishingInfo,
                           String CHARACTER_NAME, int Key){
        characterPubishingInfo.get(CHARACTER_NAME).get(Key).replace("LEVEL",
                characterPubishingInfo.get(CHARACTER_NAME).get(Key).get("LEVEL") + 1);
        System.out.println("레벨이 +1 증가했습니다.");
    }
}
