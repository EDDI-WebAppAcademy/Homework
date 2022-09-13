package kr.eddi.demo.basic.controller.vue.thirtyoneth.request;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;

@ToString
@Getter
public class RequestBuyItem {
    private Integer totalPrice;
    private ArrayList<Items> itemLists;
}