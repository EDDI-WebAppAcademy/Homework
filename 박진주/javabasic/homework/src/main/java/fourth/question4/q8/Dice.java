package fourth.question4.q8;

import java.util.Random;

public class Dice {
    public static final int min = 1;
    public static final int max = 6;

    public static void RollDice(){
        int diceResult = (int) (Math.random()* (max - min + 1) + min);
        System.out.println(diceResult);
    }

    public static void main(String[] args) {

        RollDice();
    }

}

//8. 주사위 클래스를 만들어봅시다.
// (int) Math.random() * (최댓값-최소값+1) + 최소값