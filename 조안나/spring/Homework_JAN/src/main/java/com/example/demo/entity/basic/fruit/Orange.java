package com.example.demo.entity.basic.fruit;

import java.util.LinkedList;
import java.util.Map;

public class Orange {

    public Orange() {
    }

    /**
     * 오렌지를 먹었을 때 발동되는 효과 <br>
     * 물리력이 +50 증가한다.
     */
    public void itemEffect(Map<String, LinkedList<Map<String, Integer>>> characterPubishingInfo,
                           String CHARACTER_NAME, int key){
        characterPubishingInfo.get(CHARACTER_NAME).get(key).replace("AD",
                characterPubishingInfo.get(CHARACTER_NAME).get(key).get("AD") + 50);
        System.out.println("물리력이 +50 증가했습니다.");
    }
}
