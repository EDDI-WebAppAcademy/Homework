package kr.eddi.demo.utility.basic.sixth.company1;

import kr.eddi.demo.entity.basic.sixth.Player;
import kr.eddi.demo.utility.basic.sixth.SpecialDiceOption;
import kr.eddi.demo.utility.basic.third.CustomRandom;

// 인터페이스는 상속하지 않고 구현한다고 한다.
// 왜냐하면 매서드가 작성되어 있지 않기 때문에
// implements 하는 클래스에서 매서드를 구현해줘야 한다.
public class Dice implements SpecialDiceOption {
    // 주사위 에서 있어야할 것(기능,소유,행동등)들을 생각해보자.
    private static final int MAX = 6;
    private static final int MIN = 1;

    public static int rollDice(){
        return CustomRandom.makeIntCustomRandom(MIN,MAX);
    }

    public static void steelPlayerScore(Player players[], int playerIdx, int steelScore) {
        for (int i = 0; i < players.length; i++) {
            if (i == playerIdx) { continue; }

            players[i].getScore().addScore(-steelScore);
            players[playerIdx].getScore().addScore(steelScore);
        }
    }

    public static void donatePlayerScore(Player players[], int playerIdx, int donateScore) {
        for (int i = 0; i < players.length; i++) {
            if (i == playerIdx) { continue; }

            players[playerIdx].getScore().addScore(-donateScore);
            players[i].getScore().addScore(donateScore);
        }
    }


    // 주사위를 굴리는 기능 , 특정 조건에서 스페셜 주사위를 굴리기 -> 인터페이스로나눈다
    // 왜? -> 주사위를 굴리는 행위는 어느곳에서든 같지만 특정조건이 다르다,  무엇을 할지 명시는 되어있지만 기능은 다르다는 가정하에
    @Override
    public void checkSpecialDice (Player playerS[], int diceNum, int playerIdx){
        final int SOB = 1;
        final int LUCKY = 3;
        final int DEATH = 4;
        final int BULLSHIT = 5;


        final int SOB_SCORE = 2;
        final int LUCKY_SCORE = 3;
        final int DEATH_SCORE = -4444;
        final int BULLSHIT_SCORE = 2;

        for (int i = 0; i < playerS.length; i++) {
            switch (diceNum){
                case SOB :
                    playerS[i].getScore().addScore(-SOB_SCORE);
                    break;
                case LUCKY:
                    steelPlayerScore(playerS , i ,LUCKY_SCORE);
                    break;
                case DEATH:
                    playerS[i].getScore().addScore(DEATH_SCORE);
                    break;
                case BULLSHIT:
                    donatePlayerScore(playerS , i ,BULLSHIT_SCORE);
                    break;
            }
        }
    }
}
