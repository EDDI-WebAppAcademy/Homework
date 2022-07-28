package kr.eddi.demo.utility.seven.dice;

import kr.eddi.demo.entity.six.dicegame.Player;
import kr.eddi.demo.utility.fourth.RandomNumber;

import java.util.ArrayList;

public class Dice implements SpecialDiceOption {

    private static final int  MIN = 1;
    private static final int MAX = 6;

    public static int rollDice() {
        return RandomNumber.randomNum(MIN, MAX);
    }

    public static void steelPlayerScore(ArrayList<Player> players, int playerIdx, int steelScore) {
        for (int i = 0; i < players.size(); i++) {
            if(i == playerIdx) { continue; }

            players.get(i).getScore().addScore(-steelScore);
            players.get(playerIdx).getScore().addScore(steelScore);
        }
    }

    public static void donatePlayerScore(ArrayList<Player> players, int playerIdx, int donateScore) {
        for (int i = 0; i < players.size(); i++) {
            if(i == playerIdx) { continue; }

            players.get(i).getScore().addScore(donateScore);
            players.get(playerIdx).getScore().addScore(-donateScore);

        }
    }

    // rollSpecialDice는 플레이어 객체 정보를 요구한다


    @Override
    public void checkSpecialDice(ArrayList<Player> players, int diceNum, int playerIdx) {
        final int ALL_MINUS = 1;
        final int GET_THREE_POINTS = 3;
        final int GAME_IS_OVER = 4;
        final int GIVE_TWO_POINTS = 5;

        final int ALL_MINUS_SCORE = 2;
        final int GET_THREE_POINTS_SCORE = 3;
        final int GAME_OVER_SCORE = -4444;
        final int GIVE_TWO_POINTS_SCORE = 2;

        for (int i = 0; i < players.size(); i++) {
            switch (diceNum) {
                case ALL_MINUS:
                    players.get(i).getScore().addScore(ALL_MINUS_SCORE);
                    break;

                case GET_THREE_POINTS:
                    steelPlayerScore(players, playerIdx, GET_THREE_POINTS_SCORE);
                    break;

                case GAME_IS_OVER:
                    players.get(i).getScore().setTotalScore(GAME_OVER_SCORE);
                    break;

                case GIVE_TWO_POINTS:
                    donatePlayerScore(players, playerIdx, GIVE_TWO_POINTS_SCORE);
                    break;
            }

        }
    }
}
