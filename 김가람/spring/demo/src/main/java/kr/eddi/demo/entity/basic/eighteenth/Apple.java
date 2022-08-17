package kr.eddi.demo.entity.basic.eighteenth;

import lombok.Getter;

@Getter
public class Apple implements FoodFeature {
    private String description = "hp를 50 회복시켜줍니다.";
    public int eatFood() {
        return 50;
    }

}
