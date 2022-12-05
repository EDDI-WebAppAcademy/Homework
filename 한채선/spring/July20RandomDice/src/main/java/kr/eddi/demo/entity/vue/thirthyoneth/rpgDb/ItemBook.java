package kr.eddi.demo.entity.vue.thirthyoneth.rpgDb;

import lombok.Getter;

@Getter
public enum ItemBook {

/*    HP_POTION_ONE("HP 포션 I", 50, "HP 200 회복", 200),
    HP_POTION_TWO("HP 포션 II", 200, "HP 600 회복", 600),*/

    OLD_SWORD(1, "낡은 검",5000000, "무기 공격력 100", 100),
    SWORD(2, "평범한 검", 50000000, "무기 공격력 200", 200),
    STEEL_BROAD_SWORD(3, "강철검", 150000000, "무기 공격력 300", 300),
    FLAMING_SWORD(4, "화염검", 550000000, "무기 공격력 500", 500),
    SWORD_OF_LORD(5, "군주의 검", 1000000000, "무기 공격력 1000", 1000),
    ICE_SWORD(6, "아이스소드", 1500000000, "무기 공격력 2000", 2000),
    SEVEN_BRANCHED_SWORD(7, "칠지도", 2000000000, "무기 공격력 2000", 2000),
    INSIGNIA_OF_LORD(8, "군주의 휘장", 1000000000, "악세사리 공격력 1000", 1000);

    private Integer itemId;
    private String name;
    private Integer price;
    private String description;
    private Integer atk;

    private ItemBook(Integer itemId, String name, Integer price, String description, Integer atk){
        this.name = name;
        this.price = price;
        this.description = description;
        this.atk = atk;
    }
}
