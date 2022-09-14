package com.example.demo.entity.vue.rpg;

import com.example.demo.utillity.basic.CustomRandom;

import java.util.ArrayList;
import java.util.List;

public class ItemsManager {

    public ItemsManager() {
    }

    List<ShopItems> allShopLists = new ArrayList<>();
    public void buildDefaultItemList(){

        if(allShopLists.size() == 0) {

            allShopLists.add(new ShopItems(ShopItems.SwordItem.OLD_SWORD.getName(), ShopItems.SwordItem.OLD_SWORD.getPrice(),
                    ShopItems.SwordItem.OLD_SWORD.getDescription(), ShopItems.SwordItem.OLD_SWORD.getAtk()));
            allShopLists.add(new ShopItems(ShopItems.SwordItem.SWORD.getName(), ShopItems.SwordItem.SWORD.getPrice(),
                    ShopItems.SwordItem.SWORD.getDescription(), ShopItems.SwordItem.SWORD.getAtk()));
            allShopLists.add(new ShopItems(ShopItems.SwordItem.STEEL_SWORD.getName(), ShopItems.SwordItem.STEEL_SWORD.getPrice(),
                    ShopItems.SwordItem.STEEL_SWORD.getDescription(), ShopItems.SwordItem.STEEL_SWORD.getAtk()));
            allShopLists.add(new ShopItems(ShopItems.SwordItem.FIRE_SWORD.getName(), ShopItems.SwordItem.FIRE_SWORD.getPrice(),
                    ShopItems.SwordItem.FIRE_SWORD.getDescription(), ShopItems.SwordItem.FIRE_SWORD.getAtk()));
            allShopLists.add(new ShopItems(ShopItems.SwordItem.MONARCH_SWORD.getName(), ShopItems.SwordItem.MONARCH_SWORD.getPrice(),
                    ShopItems.SwordItem.MONARCH_SWORD.getDescription(), ShopItems.SwordItem.MONARCH_SWORD.getAtk()));
            allShopLists.add(new ShopItems(ShopItems.PotionItem.HP_POTION_I.getName(), ShopItems.PotionItem.HP_POTION_I.getPrice(),
                    ShopItems.PotionItem.HP_POTION_I.getDescription(), ShopItems.PotionItem.HP_POTION_I.getRecover()));
            allShopLists.add(new ShopItems(ShopItems.PotionItem.HP_POTION_II.getName(), ShopItems.PotionItem.HP_POTION_II.getPrice(),
                    ShopItems.PotionItem.HP_POTION_II.getDescription(), ShopItems.PotionItem.HP_POTION_II.getRecover()));
        }
    }

    public void buildRandomShopList (List<ShopItems> randomShopLists) {
        int everyItemSize = allShopLists.size();

        for (int i = 0; i < 10; i++) {
            //여기서 -1 안했다고 계속 IndexOutOfBoundsException 에러가 나는 것임. . !!
            // CustomRandom 최댓값 그대로 넣는다고 +1을 해놨기 때문에 인덱스 값으로 들어가야하는 것은 다시 -1을 해줘야함. .
            // 이럴 땐 역시 빨리빨리 디버깅해서 원인을 찾자. .
            // List가 아예 생성이 안되는 줄 알고 너무 헤맸다 8ㅅ8
            ShopItems oneThing = allShopLists.get(CustomRandom.makeIntCustomRandom(0, everyItemSize - 1));
            randomShopLists.add(oneThing);
        }
    }
}
