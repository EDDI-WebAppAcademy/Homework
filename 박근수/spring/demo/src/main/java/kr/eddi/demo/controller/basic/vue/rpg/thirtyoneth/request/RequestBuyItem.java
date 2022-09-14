package kr.eddi.demo.controller.basic.vue.rpg.thirtyoneth.request;

import kr.eddi.demo.controller.basic.vue.rpg.thirtyoneth.request.Items;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;

@ToString
@Getter
public class RequestBuyItem {
    private Integer totalPrice;
    private ArrayList<Items> itemLists;
}