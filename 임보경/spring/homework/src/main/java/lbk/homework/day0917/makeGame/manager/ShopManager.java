package lbk.homework.day0917.makeGame.manager;

import lbk.homework.day0917.makeGame.entity.item.ItemBook;
import lbk.homework.day0917.makeGame.entity.item.ShopItem;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static lbk.homework.day0727.secondDiceGame.utility.CustomRandom.makeCustomRandom;

@Slf4j
@Getter
@ToString
public class ShopManager {


    private List<ShopItem> registeredItemList = new ArrayList<>();
    private List<ShopItem> shopItemsList;

    private final int NUM_OF_ITEMS_TO_SELL = 10;

    public ShopManager() {
        registerItems();
    }

    public List<ShopItem> registerItems() {
        // 레벨 별로 판매할 아이템 등록
        registeredItemList.add(new ShopItem(ItemBook.GLOVE.getNAME(), ItemBook.GLOVE.getPRICE(), ItemBook.GLOVE.getDESCRIPTION()));
        registeredItemList.add(new ShopItem(ItemBook.BAD_POTION.getNAME(), ItemBook.BAD_POTION.getPRICE(), ItemBook.BAD_POTION.getDESCRIPTION()));
        registeredItemList.add(new ShopItem(ItemBook.POTION.getNAME(), ItemBook.POTION.getPRICE(), ItemBook.POTION.getDESCRIPTION()));
        registeredItemList.add(new ShopItem(ItemBook.GO0D_POTION.getNAME(), ItemBook.GO0D_POTION.getPRICE(), ItemBook.GO0D_POTION.getDESCRIPTION()));
        registeredItemList.add(new ShopItem(ItemBook.ElIXIR.getNAME(), ItemBook.ElIXIR.getPRICE(), ItemBook.ElIXIR.getDESCRIPTION()));
        registeredItemList.add(new ShopItem(ItemBook.OLD_SWORD.getNAME(), ItemBook.OLD_SWORD.getPRICE(), ItemBook.OLD_SWORD.getDESCRIPTION()));
        registeredItemList.add(new ShopItem(ItemBook.SWORD.getNAME(), ItemBook.SWORD.getPRICE(), ItemBook.SWORD.getDESCRIPTION()));
        registeredItemList.add(new ShopItem(ItemBook.LONG_SWORD.getNAME(), ItemBook.LONG_SWORD.getPRICE(), ItemBook.LONG_SWORD.getDESCRIPTION()));

        return registeredItemList;
    }

    public List<ShopItem> prepareToSellItems() {
        shopItemsList = new LinkedList<>();
        int size = registeredItemList.size();

        for (int i = 0; i < NUM_OF_ITEMS_TO_SELL; i++) {
            shopItemsList.add(
                    registeredItemList.get(makeCustomRandom(size, 0))
            );
        }
        return shopItemsList;
    }





}
