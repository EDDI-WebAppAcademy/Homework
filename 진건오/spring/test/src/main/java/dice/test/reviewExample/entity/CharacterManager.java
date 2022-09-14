package dice.test.reviewExample.entity;

import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@ToString
public class CharacterManager {
    private int charHp;
    private int charPow;
    private Character character;
    private Map<String, Map<String, Object>> inventory;
    private Map<String, Object> takeFoodList;


    public CharacterManager(Food food) {
        character = new Character(100, 200);
        this.charHp = character.getHp();
        this.charPow = character.getPower();

        inventory = new HashMap<>();
        inventory.put("음식", food.getFood());
    }

    public void viewTakeFoodList() {
        takeFoodList = inventory.get("음식");

        for (Object food : takeFoodList.keySet()) {
            System.out.print(food+", ");
        }
    }

    public void eatFood(String foodName) {

        if (foodName.equals(FoodObject.APPLE.getFOOD_NAME())) {
            this.charHp -= FoodAbility.MIN_HP.getFOOD_ABILITY_VALUE();

        } else if (foodName.equals(FoodObject.GRAPE.getFOOD_NAME())) {
            this.charHp += FoodAbility.PLUS_HP.getFOOD_ABILITY_VALUE();

        } else if (foodName.equals(FoodObject.BREAD.getFOOD_NAME())) {
            this.charPow -= FoodAbility.MIN_POWER.getFOOD_ABILITY_VALUE();

        } else if (foodName.equals(FoodObject.ORANGE.getFOOD_NAME())) {
            this.charPow += FoodAbility.PLUS_POWER.getFOOD_ABILITY_VALUE();

        } else {
            System.out.println("없는 과일이거나 과일을 모두 먹었습니다.");
        }
        takeFoodList.remove(foodName);
    }

    public void goodFoodEatAll() {
        takeFoodList = inventory.get("음식");

        this.charHp += FoodAbility.PLUS_HP.getFOOD_ABILITY_VALUE();
        this.charPow += FoodAbility.PLUS_POWER.getFOOD_ABILITY_VALUE();

        takeFoodList.clear();
        inventory.clear();
    }
}
