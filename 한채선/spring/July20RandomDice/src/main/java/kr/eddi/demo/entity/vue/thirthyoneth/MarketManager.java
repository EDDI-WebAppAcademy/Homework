package kr.eddi.demo.entity.vue.thirthyoneth;

import kr.eddi.demo.entity.vue.thirthyoneth.rpgDb.ItemBook;
import kr.eddi.demo.utility.fourth.CustomRandomNumber;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
@Getter
public class MarketManager {

    private List<ShopItem> shopItemsDataBase;
    private List<ShopItem> randomShopList;
    private int totalShopItemDBSize;

    public MarketManager() {
        shopItemsDataBase = new ArrayList<>();
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


    /**
     * db에서 랜덤한 아이템을 불러와 randomShopList에 추가
     */
    public void buildRandomShopItem() {
        int randomItemIndex = CustomRandomNumber.randomNum(0, totalShopItemDBSize -1);
        ShopItem oneThing = shopItemsDataBase.get(randomItemIndex);
        randomShopList.add(oneThing);
    }

    /**
     * buildRandomShopItem 메소드를 받은 파라미터수만큼 반복함
     * 파라미터 수만큼의 랜덤한 아이템들이 들어간 리스트를 생성
     */
    public void buildRandomShopItemsList(int itemNums) {
        randomShopList = new ArrayList<>();
        for (int i = 0; i < itemNums; i++) {
            buildRandomShopItem();
        }
    }

}
