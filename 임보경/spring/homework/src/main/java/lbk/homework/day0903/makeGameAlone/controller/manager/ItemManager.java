package lbk.homework.day0903.makeGameAlone.controller.manager;

import lbk.homework.day0903.makeGameAlone.entity.item.Item;
import lbk.homework.day0903.makeGameAlone.entity.item.ItemBook;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static lbk.homework.day0727.secondDiceGame.utility.CustomRandom.makeCustomRandom;

@ToString
@Getter
public class ItemManager {
    private List<Item> shopList;
    private ItemBook itemBook;
    private int stockNumber = 10;
    // data 받는 영역
    ArrayList<Item> shoppingCart;
    ArrayList<Item> receiveEquipItem;

    public ItemManager() {
        shopList = new LinkedList<>();
        itemBook = new ItemBook();
    }



    public List<Item> stockController () {
        // 상점에 나올 개수만큼 샵리스트에 저장
        for(int i = 0; i < stockNumber; i++) {
            shopList.add(acquireRandomItem());
        }
        return shopList;
    }

    public Item acquireRandomItem () {
        int size = itemBook.getItemBooks().size();
        return itemBook.getItemBooks().get(makeCustomRandom( size, 0));
    }


}
