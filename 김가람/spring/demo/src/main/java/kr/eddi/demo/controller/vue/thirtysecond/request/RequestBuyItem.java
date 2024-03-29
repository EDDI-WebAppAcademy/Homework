package kr.eddi.demo.controller.vue.thirtysecond.request;

import kr.eddi.demo.entity.vue.thirtiyfirst.UserItems;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;

@ToString
@Getter
public class RequestBuyItem {
    private Integer totalPrice;
    private ArrayList<UserItems> itemLists;
}
