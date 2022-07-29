package kr.eddi.homework.entity.sixth;

public class Dice {
    private final int MAX = 6;
    private static int score;


    /*
    * @return 주사위 값
    * */
    public static int rollDice(int MAX){
        score = (int)(Math.random()*MAX)+1;
        return score;
    }

}
