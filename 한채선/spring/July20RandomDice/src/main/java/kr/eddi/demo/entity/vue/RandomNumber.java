package kr.eddi.demo.entity.vue;

import kr.eddi.demo.utility.fourth.CustomRandomNumber;
import lombok.Getter;

@Getter
public class RandomNumber {

    private int randomNum;
    public RandomNumber() {
        randomNum = CustomRandomNumber.randomNum(1, 10);
    }
}
