package lbk.homework.day0812.javaPrcatice;

import lombok.Getter;

import java.util.*;

@Getter
public class Food implements GameItem {

    private Map<String, String> foods;

    public Food(){
        foods = new HashMap<>();

        foods.put("사과", "hp +20");
        foods.put("사과", "hp +20");
        foods.put("사과", "hp +20");

        foods.put("귤", "hp +10");
        foods.put("포도", "mp +20");
        foods.put("빵", "hp +100");
        foods.put("빵", "hp +100");
    }


    @Override
    public void eat(String key) {
        System.out.println(key + "를 먹었습니다.");
        System.out.println( foods.get(key) + "이/가 회복되었습니다.");
    }

    @Override
    public void eat(String key, int num) {
        System.out.println("내가 " + key + "*" + num + "를 먹었습니다.");

        for (int i = 0; i < num; i++) {
            System.out.println( foods.get(key) + "이/가 회복되었습니다.");
        }
    }
}
