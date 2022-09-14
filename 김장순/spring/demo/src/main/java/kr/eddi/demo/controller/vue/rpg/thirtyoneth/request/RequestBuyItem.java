package kr.eddi.demo.controller.vue.rpg.thirtyoneth.request;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;

@Getter
@ToString
public class RequestBuyItem {
    private Integer totalPrice;
    private ArrayList<Items> itemLists;
}
