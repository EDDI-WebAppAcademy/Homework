package lbk.homework.day0903.makeGameAlone.controller.manager;

import lbk.homework.day0903.makeGameAlone.entity.item.Items;
import lombok.Getter;

import java.util.LinkedList;
import java.util.List;

import static lbk.homework.day0727.secondDiceGame.utility.CustomRandom.makeCustomRandom;


@Getter
public class ShopManager {
    private List<Object> shopList;
    private Items items;
    private int stockNumber = 10;

    public ShopManager() {
        shopList = new LinkedList<>();
        items = new Items();
    }

    public List stockController () {
        // 상점에 나올 개수만큼 샵리스트에 저장
        for(int i = 0; i < stockNumber; i++) {
            shopList.add(acquireRandomItem());
        }
        return shopList;
    }

    public Object acquireRandomItem () {
        int size = items.getItemBooks().size();
        return items.getItemBooks().get(makeCustomRandom( size, 0));
    }

}
