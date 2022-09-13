package com.example.demo.entity.vue.rpg;

import lombok.Getter;

@Getter
public class ShopItems {
    public ShopItems(String name, Integer price, String description, Integer atk) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.atk = atk;
    }

    public ShopItems(String name, Integer price, String description, String recover) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.recover = recover;
    }

    private String name;
    private Integer price;
    private String description;
    private Integer atk;
    private String recover;


    @Getter
    public enum SwordItem {
        OLD_SWORD("낡은 검", 5000000, "무기 공격력 100", 100),
        SWORD("검", 50000000, "무기 공격력 200", 200),
        STEEL_SWORD("강철 검", 150000000, "무기 공격력 500", 300),
        FIRE_SWORD("화열 검", 550000000, "무기 공격력 500", 500),
        MONARCH_SWORD("군주의 검", 1000000000, "무기 공격력 1000", 1000);


        private final String name;
        private final Integer price;
        private final String description;
        private final Integer atk;

        SwordItem(String name, Integer price, String description, Integer atk) {
            this.name = name;
            this.price = price;
            this.description = description;
            this.atk = atk;
        }
    }

    @Getter
    public enum PotionItem{
        HP_POTION_I("HP 포션 I", 50, "hp 200 회복", "200"),
        HP_POTION_II("HP 포션 II", 200, "hp 600 회복", "600");

        private final String name;
        private final Integer price;
        private final String description;
        private final String recover;

        PotionItem(String name, Integer price, String description, String recover) {
            this.name = name;
            this.price = price;
            this.description = description;
            this.recover = recover;
        }
    }
}

