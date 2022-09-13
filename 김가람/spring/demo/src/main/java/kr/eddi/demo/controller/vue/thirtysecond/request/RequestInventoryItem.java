package kr.eddi.demo.controller.vue.thirtysecond.request;


import kr.eddi.demo.entity.vue.thirtiyfirst.ShopItems;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class RequestInventoryItem {

    private ArrayList<ShopItems> EquippedInventoryItem;
}
