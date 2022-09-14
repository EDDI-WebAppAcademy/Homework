package kr.eddi.demo.entity.basic.eighteenth;

public class Grape implements FoodFeature {
    private String description = "hp를 200 회복시켜줍니다.";

    public int eatFood() {
        return 200;
    }
}
