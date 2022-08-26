package kr.eddi.demo.entity.basic.eighteenth;

public class Banana implements FoodFeature{
    private String description = "hp를 500 회복시켜줍니다.";

    public int eatFood() {
        return 500;
    }
}
