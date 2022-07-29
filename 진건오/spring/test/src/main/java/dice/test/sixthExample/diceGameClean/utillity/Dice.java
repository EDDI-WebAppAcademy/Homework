package dice.test.sixthExample.diceGameClean.utillity;

import dice.test.fifthExample.third.entity.CreateRandom;
import dice.test.sixthExample.diceGameClean.entity.Player;
import dice.test.sixthExample.diceGameClean.entity.Score;

public class Dice implements EffectDiceNum{

    private static final int DICE_MAX_RANGE = 6;
    private static final int DICE_MIN_RANGE = 1;
    private static String str = "";


    public static int rollDice() {
        int diceNum = CreateRandom.makeToCreateRandom(DICE_MAX_RANGE, DICE_MIN_RANGE);
        return diceNum;
    }

    public static void diceNum1Process(Player[] players, int diceNum, int diceNum2Penalty) {
        for (int i = 0; i < players.length; i++) {
            players[i].getScore().calcScore(-(diceNum2Penalty));
        }
        str += "주사위 숫자 [" + diceNum + "] : 플레이어의 점수가 " + diceNum2Penalty + "점씩 감점<br>" +
                "다음 턴";
    }

    public static void diceNum3Process(Player[] players, int diceNum, int diceNum3Penalty, int currentPlayer) {
        for (int j = 0; j < players.length; j++) {
            if (j == currentPlayer) {
                continue;
            }
            players[j].getScore().calcScore(-diceNum3Penalty);
            players[currentPlayer].getScore().calcScore(diceNum3Penalty);
        }
        str += "주사위 숫자 [" + diceNum + "] : 현재 플레이어에게 [" + diceNum3Penalty + "]점씩 넘겨줍니다.<br>"+
                "다음 턴";
    }

    public static void diceNum5Process(Player[] players, int diceNum, int diceNum5Penalty, int currentPlayer) {
        for (int j = 0; j < players.length; j++) {
            if (j == currentPlayer) {
                continue;
            }
            players[currentPlayer].getScore().calcScore(-diceNum5Penalty);
            players[j].getScore().calcScore(diceNum5Penalty);
        }
        str += "주사위 숫자 [" + diceNum + "] : 현재 플레이어에게 [" + diceNum5Penalty + "]점씩 넘겨줍니다.<br>"+
                "다음 턴";
    }

    @Override
    public String effectDiceNumApply(Player[] players, String playersName,int diceNum, int currentPlayer) {
        final int allPlayersMin1 = 1;
        final int allPlayersGive3PointCurrentPlayer = 3;
        final int playerDie = 4;
        final int currentPlayerOtherPlayers2Point = 5;

        final int diceNum2Penalty = 2;
        final int diceNum3Penalty = 3;
        final int diceNum4Penalty = -99999;
        final int diceNum5Penalty = 2;


        str += "플레이어 [" + players.length + "] 명이 게임에 참가하였습니다.<br>" +
                "게임시작";

        for (int i = 0; i < players.length; i++) {

            if (diceNum == allPlayersMin1) {
//                players[i].getScore().calcScore(-(diceNum2Penalty));
//                str += "주사위 숫자 [" + diceNum + "] : 플레이어의 점수가 " + diceNum2Penalty + "점씩 감점<br>" +
//                        "현재 플레이어점수 : ["+players[i].getScore()+ "]점<br>" +
//                        "다음 턴";
                diceNum1Process(players, diceNum, diceNum2Penalty);

            } else if (diceNum == allPlayersGive3PointCurrentPlayer) {
//                for (int j = 0; j < players.length; j++) {
//                    if (j == currentPlayer) {
//                        continue;
//                    }
//                    players[j].getScore().calcScore(-diceNum3Penalty);
//                    players[currentPlayer].getScore().calcScore(diceNum3Penalty);
//                }
//                currentPlayerScore = players[i].getScore();
//                str += "주사위 숫자 [" + diceNum + "] : 현재 플레이어에게 [" + diceNum3Penalty + "]점씩 넘겨줍니다.<br>" +
//                        "현재 플레이어점수 : ["+currentPlayerScore+"]점<br>" +
//                        "다음 턴";
                diceNum3Process(players, diceNum, diceNum3Penalty, currentPlayer);

            } else if (diceNum == playerDie) {
                players[i].getScore().setTotalScore(diceNum4Penalty);
                str += "주사위 숫자 [" + diceNum + "] : 현재 플레이어는 게임에서 졌습니다.<br>" +
                        "다음 턴";

            } else if (diceNum == currentPlayerOtherPlayers2Point) {
//                for (int j = 0; j < players.length; j++) {
//                    if (j == currentPlayer) {
//                        continue;
//                    }
//                    players[currentPlayer].getScore().calcScore(-diceNum5Penalty);
//                    players[j].getScore().calcScore(diceNum5Penalty);
//                }
//                str += "주사위 숫자 [" + diceNum + "] : 현재 플레이어의 점수에서 2점씩 다른 플레이어에게 부여합니다.<br>" +
//                        "현재 플레이어점수 : ["+players[i].getScore()+"]점<br>" +
//                        "다음 턴";
                diceNum5Process(players, diceNum, diceNum5Penalty, currentPlayer);
            }
        }
        str += "게임 종료";
        return str;
    }
}
