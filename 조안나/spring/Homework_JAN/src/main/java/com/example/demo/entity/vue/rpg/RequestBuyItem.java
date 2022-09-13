package com.example.demo.entity.vue.rpg;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;

@ToString
@Getter
public class RequestBuyItem {
    private Integer totalPrice;
    private ArrayList<Items> itemLists;
}
