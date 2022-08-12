package com.example.demo.entity.basic.fruit;

import java.util.LinkedList;
import java.util.Map;

public interface ItemEffect {
    public void itemEffect(Map<String, LinkedList<Map<String, Integer>>> characterPubishingInfo,
                           String CHARACTER_NAME, int Key);
}
