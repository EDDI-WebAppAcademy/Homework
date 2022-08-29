package dice.test.reviewExample.entity;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class Food {
    Map<String,Object> food = new HashMap();

//    public void inputFood() {
//        food.put("사과", new Apple());
//        food.put("포도", new Grape());
//        food.put("오렌지", new Orange());
//        food.put("딸기", new Strawberry());
//    }

    public Food() {
        food.put(FoodObject.APPLE.getFOOD_NAME(), FoodAbility.MIN_HP);
        food.put(FoodObject.GRAPE.getFOOD_NAME(), FoodAbility.PLUS_HP);
        food.put(FoodObject.BREAD.getFOOD_NAME(), FoodAbility.MIN_POWER);
        food.put(FoodObject.ORANGE.getFOOD_NAME(), FoodAbility.PLUS_POWER);
    }
}
