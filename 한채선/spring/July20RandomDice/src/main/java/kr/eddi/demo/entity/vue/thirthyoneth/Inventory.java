package kr.eddi.demo.entity.vue.thirthyoneth;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
@NoArgsConstructor
public class Inventory {

    private List<Object> shopCheckedItem;
    private int totalPrice;

    public Inventory(List<Object> shopCheckedItem, int totalPrice) {
        this.shopCheckedItem = shopCheckedItem;
        this.totalPrice = totalPrice;
    }
}
