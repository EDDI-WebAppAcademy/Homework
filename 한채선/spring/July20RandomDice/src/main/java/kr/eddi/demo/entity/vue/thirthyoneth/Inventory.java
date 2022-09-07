package kr.eddi.demo.entity.vue.thirthyoneth;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
public class Inventory {

    private List<ShopItem> checkedItem;
    private int totalPrice;
}
