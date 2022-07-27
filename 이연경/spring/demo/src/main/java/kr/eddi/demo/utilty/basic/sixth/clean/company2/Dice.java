package kr.eddi.demo.utilty.basic.sixth.clean.company2;
import kr.eddi.demo.entity.basic.sixth.clean.Player;
import kr.eddi.demo.utilty.basic.sixth.clean.SpecialDiceOption;
import kr.eddi.demo.utilty.basic.third.CustomRandom;



public class Dice implements SpecialDiceOption {
    private static final int MIN = 1;
    private static final int MAX = 6;

    public static int rollDice() {
        return CustomRandom.makeIntCustomRandom(MIN, MAX);
    }

    @Override
    public void checkSpecialDice(Player player[], int diceNum, int playerIdx) {

    }
}