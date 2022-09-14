package dice.test.reviewExample.entity;

import lombok.Getter;

@Getter
public enum FoodObject {

    APPLE("사과", 1),
    GRAPE("포도", 2),
    BREAD("빵", 3),
    ORANGE("오렌지",4);

    private final String FOOD_NAME;
    private final int FOOD_VALUE;

    FoodObject(String foodName, int foodValue) {
        this.FOOD_NAME = foodName;
        this.FOOD_VALUE = foodValue;
    }
}
