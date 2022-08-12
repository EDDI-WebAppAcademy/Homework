package com.example.demo.entity.basic.fruit;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class GameCharacter {
    /**
     * 캐릭터 이름 : String, List(HP, HPValue / AD, ADValue / AP, APValue / LEVEL, LEVELValue)
     */
    private Map<String, LinkedList<Map<String, Integer>>> characterPubishingInfo;
    private String charaterName;


    public GameCharacter(String CHARACTER_NAME) {
        this.charaterName = CHARACTER_NAME;
        characterPubishingInfo = new HashMap<>();
    }

    /**
     * 캐릭터 이름과 캐릭터 스킬 정보 리스트를 저장하는 메서드
     * @param characterInfoList
     */
    public Map<String, LinkedList<Map<String, Integer>>> characterPubishingInfo
        (LinkedList<Map<String, Integer>> characterInfoList){
            characterPubishingInfo.put(charaterName, characterInfoList);
            return characterPubishingInfo;
    }
}
