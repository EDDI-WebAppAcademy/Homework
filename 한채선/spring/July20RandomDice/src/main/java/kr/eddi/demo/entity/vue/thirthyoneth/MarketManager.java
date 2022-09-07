package kr.eddi.demo.entity.vue.thirthyoneth;

import kr.eddi.demo.entity.vue.thirthyoneth.Monster.Monster;
import kr.eddi.demo.utility.fourth.CustomRandomNumber;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class MarketManager {

    private List<ShopItem> shopItemsDataBase;
    private List<ShopItem> randomShopList;

    int totalShopItemDBSize;

    public MarketManager() {
        shopItemsDataBase = new ArrayList<>();
        randomShopList = new ArrayList<>();
        buildShopItemDataBase();
    }

    public void buildShopItemDataBase() {
        shopItemsDataBase.add(new ShopItem(ItemBook.OLD_SWORD.getName(),ItemBook.OLD_SWORD.getPrice(), ItemBook.OLD_SWORD.getDescription(), ItemBook.OLD_SWORD.getAtk()));
        shopItemsDataBase.add(new ShopItem(ItemBook.SWORD.getName(),ItemBook.SWORD.getPrice(), ItemBook.SWORD.getDescription(), ItemBook.SWORD.getAtk()));
        shopItemsDataBase.add(new ShopItem(ItemBook.STEEL_BROAD_SWORD.getName(),ItemBook.STEEL_BROAD_SWORD.getPrice(), ItemBook.STEEL_BROAD_SWORD.getDescription(), ItemBook.STEEL_BROAD_SWORD.getAtk()));
        shopItemsDataBase.add(new ShopItem(ItemBook.FLAMING_SWORD.getName(),ItemBook.FLAMING_SWORD.getPrice(), ItemBook.FLAMING_SWORD.getDescription(), ItemBook.FLAMING_SWORD.getAtk()));
        shopItemsDataBase.add(new ShopItem(ItemBook.SWORD_OF_LORD.getName(),ItemBook.SWORD_OF_LORD.getPrice(), ItemBook.SWORD_OF_LORD.getDescription(), ItemBook.SWORD_OF_LORD.getAtk()));
        shopItemsDataBase.add(new ShopItem(ItemBook.SWORD.getName(),ItemBook.SWORD.getPrice(), ItemBook.SWORD.getDescription(), ItemBook.SWORD.getAtk()));
        shopItemsDataBase.add(new ShopItem(ItemBook.ICE_SWORD.getName(),ItemBook.ICE_SWORD.getPrice(), ItemBook.ICE_SWORD.getDescription(), ItemBook.ICE_SWORD.getAtk()));
        shopItemsDataBase.add(new ShopItem(ItemBook.SEVEN_BRANCHED_SWORD.getName(),ItemBook.SEVEN_BRANCHED_SWORD.getPrice(), ItemBook.SEVEN_BRANCHED_SWORD.getDescription(), ItemBook.SEVEN_BRANCHED_SWORD.getAtk()));
        shopItemsDataBase.add(new ShopItem(ItemBook.INSIGNIA_OF_LORD.getName(),ItemBook.INSIGNIA_OF_LORD.getPrice(), ItemBook.INSIGNIA_OF_LORD.getDescription(), ItemBook.INSIGNIA_OF_LORD.getAtk()));

        totalShopItemDBSize = shopItemsDataBase.size();
    }

    public void buildRandomShopItem() {
        int randomItemIndex = CustomRandomNumber.randomNum(0, totalShopItemDBSize -1);
        ShopItem oneThing = shopItemsDataBase.get(randomItemIndex);
        randomShopList.add(oneThing);
    }

    public void buildRandomShopItemsList(int itemNums) {
        for (int i = 0; i < itemNums; i++) {
            buildRandomShopItem();
        }
    }
}
