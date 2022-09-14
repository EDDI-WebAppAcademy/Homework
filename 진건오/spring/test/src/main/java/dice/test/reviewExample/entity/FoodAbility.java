package dice.test.reviewExample.entity;

import lombok.Getter;

@Getter
public enum FoodAbility {
    MIN_HP("체력감소", 50),
    PLUS_HP("체력증가", 50),
    MIN_POWER("공격력감소", 100),
    PLUS_POWER("공격력증가", 100);

    private final String FOOD_ABILITY_NAME;
    private final int FOOD_ABILITY_VALUE;

    FoodAbility(String FOOD_ABILITY_NAME, int FOOD_ABILITY_VALUE) {
        this.FOOD_ABILITY_NAME = FOOD_ABILITY_NAME;
        this.FOOD_ABILITY_VALUE = FOOD_ABILITY_VALUE;
    }
}
