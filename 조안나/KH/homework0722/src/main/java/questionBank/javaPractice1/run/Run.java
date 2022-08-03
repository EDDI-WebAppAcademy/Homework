package questionBank.javaPractice1.run;

import questionBank.javaPractice1.controller.DiceController;
import questionBank.javaPractice1.entity.Players;

public class Run {
    private static int PLAY_USER_NUM = 3;
    private static int START_SCORE = 10;

    public static void main(String[] args) {

        DiceController diceController = new DiceController(PLAY_USER_NUM, START_SCORE);

    }

}
