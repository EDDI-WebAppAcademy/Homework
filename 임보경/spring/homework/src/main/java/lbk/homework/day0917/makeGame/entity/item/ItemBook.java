package lbk.homework.day0917.makeGame.entity.item;

import lombok.Getter;

@Getter
public enum ItemBook {

    BAD_POTION ("초급 포션", 50, 10, "HP 50 회복" , -1),
    POTION ("중급 포션", 200, 180, "HP 200 회복" , -1),
    GO0D_POTION ("고급 포션", 500, 600, "HP 500 회복" , -1),
    ElIXIR ("엘릭서", 4000, 10, "HP 4000 회복" , -1),
    OLD_SWORD ("낡은 검", 50, 100, "ATK 50 증가", 0),
    SWORD ("검", 150, 1500, "ATK 150 증가", 0),
    LONG_SWORD ("롱소드", 270, 4100, "ATK 270 증가", 0),
    GLOVE ("낡은 글로브", 10, 300, "DEF 10 증가", 0);

    private final String NAME;
    private final Integer MOUNT;
    private final Integer PRICE;
    private final String DESCRIPTION;
    private final Integer CHECK_EQUIPMENT_STATUS;

    ItemBook(String NAME, Integer MOUNT, Integer PRICE, String DESCRIPTION, Integer CHECK_EQUIPMENT_STATUS) {
        this.NAME = NAME;
        this.MOUNT = MOUNT;
        this.PRICE = PRICE;
        this.DESCRIPTION = DESCRIPTION;
        this.CHECK_EQUIPMENT_STATUS = CHECK_EQUIPMENT_STATUS;
    }
}
