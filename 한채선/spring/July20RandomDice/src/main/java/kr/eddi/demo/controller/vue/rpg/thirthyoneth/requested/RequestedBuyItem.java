package kr.eddi.demo.controller.vue.rpg.thirthyoneth.requested;

import kr.eddi.demo.entity.vue.thirthyoneth.ShopItem;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;


@ToString
@Getter
@NoArgsConstructor
public class RequestedBuyItem {

    private List<ShopItem> itemList;
    private int totalPrice;

    public RequestedBuyItem(List<ShopItem> itemList) {
        this.itemList = itemList;
    }

    public void calcBuyList() {
        totalPrice = 0;

        for (int i = 0; i < itemList.size(); i++) {
            totalPrice += itemList.get(i).getPrice();
        }
    }
}
