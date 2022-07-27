package kr.eddi.demo.utility.six.afterClassDiceGame;

import kr.eddi.demo.entity.six.dicegame.Player;
import kr.eddi.demo.utility.fourth.RandomNumber;
import kr.eddi.demo.utility.six.SpecialDiceOption;

public class Dice  implements SpecialDiceOption {

    private static final int  MIN = 1;
    private static final int MAX = 6;

    public static int rollDice() {
        return RandomNumber.randomNum(MIN, MAX);
    }

    public static void steelPlayerScore(Player players[], int playerIdx, int steelScore) {
        for (int i = 0; i < players.length; i++) {
            if(i == playerIdx) { continue; }

            players[i].getScore().addScore(-steelScore);
            players[playerIdx].getScore().addScore(steelScore);
        }
    }

    public static void donatePlayerScore(Player players[], int playerIdx, int donateScore) {
        for (int i = 0; i < players.length; i++) {
            if(i == playerIdx) { continue; }

            players[i].getScore().addScore(donateScore);
            players[playerIdx].getScore().addScore(-donateScore);

        }
    }

    // rollSpecialDice는 플레이어 객체 정보를 요구한다


    @Override
    public void checkSpecialDice(Player[] players, int diceNum, int playerIdx) {
        final int ALL_MINUS = 1;
        final int GET_THREE_POINTS = 3;
        final int GAME_IS_OVER = 4;
        final int GIVE_TWO_POINTS = 5;

        final int ALL_MINUS_SCORE = 2;
        final int GET_THREE_POINTS_SCORE = 3;
        final int GAME_OVER_SCORE = -4444;
        final int GIVE_TWO_POINTS_SCORE = 2;

        for (int i = 0; i < players.length; i++) {
            switch (diceNum) {
                case ALL_MINUS:
                    players[i].getScore().addScore(ALL_MINUS_SCORE);
                    break;
                case GET_THREE_POINTS:
                    steelPlayerScore(players, playerIdx, GET_THREE_POINTS_SCORE);
                    break;
                case GAME_IS_OVER:
                    players[i].getScore().setTotalScore(GAME_OVER_SCORE);
                    break;
                case GIVE_TWO_POINTS:
                    donatePlayerScore(players, playerIdx, GIVE_TWO_POINTS_SCORE);
                    break;
            }

        }
    }
}
