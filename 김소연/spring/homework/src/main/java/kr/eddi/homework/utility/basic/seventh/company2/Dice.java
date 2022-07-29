package kr.eddi.homework.utility.basic.seventh.company2;

import kr.eddi.homework.entity.seventh.Player;
import kr.eddi.homework.utility.basic.seventh.SpecialDiceOption;
import kr.eddi.homework.utility.basic.third.CustomRandom;

public class Dice implements SpecialDiceOption {
    private static final int MIN = 1;
    private static final int MAX = 6;


    public static int rollDice(){
        return CustomRandom.makeIntCustomRandom(MIN,MAX);
    }


    @Override
    public void checkSpecialDice(Player[] players, int diceNum, int playerIdx) {

    }

    //2번쨰 주사위의 옵션들 관리

}
