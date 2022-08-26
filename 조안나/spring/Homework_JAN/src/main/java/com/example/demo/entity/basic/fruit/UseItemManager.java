package com.example.demo.entity.basic.fruit;

import java.util.LinkedList;
import java.util.Map;

public class UseItemManager{
    private int HP = 0;
    private int AD= 1;
    private int AP = 2;
    private int LEVEL = 3;


    /**
     * 입력받은 아이템에 따라 아이템이 사용되는 메서드
     * @param itemName 사과 / 오렌지 / 포도 / 빵
     * @param characterPubishingInfo 변경 될 정보를 가진 Map
     * @param CHARACTER_NAME 캐릭터 이름
     */
    public void useItem(String itemName, Map<String, LinkedList<Map<String, Integer>>> characterPubishingInfo,
                        String CHARACTER_NAME){
        switch (itemName){
            case "사과" :
                Apple apple = new Apple();
                apple.itemEffect(characterPubishingInfo, CHARACTER_NAME, HP);
                break;
            case "오렌지" :
                Orange orange = new Orange();
                orange.itemEffect(characterPubishingInfo, CHARACTER_NAME, AD);
                break;
            case "포도" :
                Grape grape = new Grape();
                grape.itemEffect(characterPubishingInfo, CHARACTER_NAME, AP);
                break;
            case "빵" :
                Bread bread = new Bread();
                bread.itemEffect(characterPubishingInfo, CHARACTER_NAME, LEVEL);
                break;
            }
    }
}

