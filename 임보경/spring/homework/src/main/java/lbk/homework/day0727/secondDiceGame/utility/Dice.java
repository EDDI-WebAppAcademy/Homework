package lbk.homework.day0727.secondDiceGame.utility;


import static lbk.homework.day0727.secondDiceGame.utility.CustomRandom.makeCustomRandom;

public class Dice {
    private static final int MIN = 1;
    private static final int MAX = 6;

    public static int rollDice(){
        return makeCustomRandom(MAX, MIN);
    }
}
