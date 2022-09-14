package com.example.demo.entity.basic.fruit;

import java.util.LinkedList;
import java.util.Map;

public class Apple implements ItemEffect{

    public Apple() {
    }

    /**
     * 사과를 먹었을 때 발동되는 효과 <br>
     * 체력이 +50 증가한다
     */
    public void itemEffect(Map<String, LinkedList<Map<String, Integer>>> characterPubishingInfo,
                           String CHARACTER_NAME, int Key){
        characterPubishingInfo.get(CHARACTER_NAME).get(Key).replace("HP",
                characterPubishingInfo.get(CHARACTER_NAME).get(Key).get("HP") + 50);
        System.out.println("체력이 +50 증가했습니다.");
    }
}
