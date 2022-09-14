package kr.eddi.demo.controller.vue.requset;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;

@Getter
@ToString
public class RequestBuyItem {
    private Integer totalPrice;
    private ArrayList<Items> itemLists;
}
