package com.example.demo.entity.basic.fruit;

import java.util.LinkedList;
import java.util.Map;

public class Grape {
    public Grape() {
    }

    /**
     * 포도를 먹었을 때 발동되는 효과 <br>
     * 주문력이 +50 증가한다.
     */
    public void itemEffect(Map<String, LinkedList<Map<String, Integer>>> characterPubishingInfo,
                           String CHARACTER_NAME, int key){
        characterPubishingInfo.get(CHARACTER_NAME).get(key).replace("AP",
                characterPubishingInfo.get(CHARACTER_NAME).get(key).get("AP") + 50);
        System.out.println("주문력이 +50 증가했습니다.");
    }
}
