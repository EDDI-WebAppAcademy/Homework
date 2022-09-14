package lbk.homework.day0902.vue.entity;

import lbk.homework.day0728.strangeLotto.utility.CustomRandom;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class RandomNumber {
    private int randomNumber;

    public RandomNumber() {
        randomNumber = CustomRandom.makeCustomRandom(10, 1);
    }
}
