package com.example.homework.javapractice.total;

import java.util.Map;

public interface EatFood {
    //특정 과일을 먹었을 때 player가 가진 수치를 변하게 만드는 메소드를 선언해야 하는딩?
    public void changeStatus(String foodType, Map<String, Integer> food);
}
