package dice.test.sixthExample.diceGame.entity;

import dice.test.fifthExample.third.entity.CreateRandom;

import java.util.Arrays;

public class RunDiceGame {
    private final int numberOfPlayers;
    private final int startPlayersScore;
    private static final int penalty_Value_For_Dice_Number_5 = 2;
    private static final int penalty_Value_For_Dice_Number_3 = 3;
    private static int DICE_NUM_MAX = 6;
    private static int DICE_NUM_MIN = 1;
    private static int reCreateDiceNum = 0;
    private static String str = " ";
    private static int playerScoreAddDiceNum;
    public RunDiceGame(int numberOfPlayers, int startPlayersScore) {
        this.numberOfPlayers = numberOfPlayers;
        this.startPlayersScore = startPlayersScore;
    }

    public static void evenNumProcess(int playerScoreAddDiceNum) {
        reCreateDiceNum = CreateRandom.makeToCreateRandom(DICE_NUM_MAX, DICE_NUM_MIN);
        playerScoreAddDiceNum += reCreateDiceNum;
        str += "첫번째 주사위를 굴렸을 때 짝수가 나와 다시 주사위를 돌립니다.<br>[다시 굴렸을때 나오는 주사위 값은 ["+reCreateDiceNum+"]입니다.<br>" +
                "총 점수: ["+playerScoreAddDiceNum+"]점<br>" +
                "-----------------------------------NEXT TURN--------------------------------------<br>";
    }

    public static void diceNum_1_process(int[] players) {
        for (int i = 0; i < players.length; i++) {
            players[i] = players[i] - 2;
        }
        str += "주사위가 1이 나와 모든 플레이어의 점수가 -2씩 감점됩니다.<br>" +
                            "<br>-----------------------------------NEXT TURN--------------------------------------<br>";
    }

    public static void diceNum_3_process(int[] players, int numberOfPlayers) {
        playerScoreAddDiceNum += ((numberOfPlayers - 1) * penalty_Value_For_Dice_Number_3);
        int index = Arrays.binarySearch(players, playerScoreAddDiceNum);

        for (int j = 0; j < numberOfPlayers; j++) {
            if (j == index) {
                continue;
            }
            players[j] += (players[j] - penalty_Value_For_Dice_Number_3);

        }
        str += "주사위 3이 나와 현재 플레이어에게 3점씩 넘겨줍니다.<br>" +
                "<br>-----------------------------------NEXT TURN--------------------------------------<br>";
    }

//    public static void diceNum_4_process(int[] players) {
//        int index = Arrays.binarySearch(players, playerScoreAddDiceNum);
//        players[index] = 0;
//        str += "주사위 숫자가 4가 나와 모든 점수를 잃게 되어 게임에서 졌습니다.<br>" +
//                "<br>-----------------------------------NEXT TURN--------------------------------------<br>";
//    }

    public static String startDiceGame(int numberOfPlayers, int startPlayersScore) {
        str = "<br>======================================================<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                "📢플레이어 ["+numberOfPlayers + "] 명이 게임에 참가하였습니다. " +
                "<br>======================================================<br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                "📢<<게임을 시작합니다>>" +
                "<br>======================================================<br>" ;

        int[] players = PlayerSetting.playerScoreSetting(numberOfPlayers, startPlayersScore);

        for (int i = 0; i < numberOfPlayers; i++) {
            int playerDoRollDiceNum = CreateRandom.makeToCreateRandom(DICE_NUM_MAX, DICE_NUM_MIN);
            playerScoreAddDiceNum = (players[i] + playerDoRollDiceNum);
            str += "[" + (i+1) + "번 플레이어] : > 주사위 수 [" + playerDoRollDiceNum+"]<br>";

            if (players[i] <= 0) {
                players[i] = 0;
                str += "[" + (i+1) + "번 플레이어] 가 모든 점수를 소진하여 0점입니다." +
                        "-----------------------------------NEXT TURN--------------------------------------";
            }


            if (playerDoRollDiceNum % 2 == 0) {
                evenNumProcess(playerScoreAddDiceNum);

                if (reCreateDiceNum == 1) {
                    diceNum_1_process(players);

                } else if (reCreateDiceNum == 3) {
                    diceNum_3_process(players,numberOfPlayers);

                } else if (reCreateDiceNum == 4) {
                    players[i] = 0;
                    str += "주사위 숫자가 4가 나와 [" + (i + 1) + "번 플레이어]는 모든 점수를 잃게 되어 게임에서 졌습니다.<br>" +
                            "<br>-----------------------------------NEXT TURN--------------------------------------<br>";
//                    diceNum_4_process(players);
                } else if (reCreateDiceNum == 5) {
                    players[i] -= ((numberOfPlayers - 1) * penalty_Value_For_Dice_Number_5);
                    for (int j = 0; j < numberOfPlayers; j++) {
                        if (j == i) {
                            continue;
                        }
                        players[j] += (players[j] + penalty_Value_For_Dice_Number_5);
                    }
                }

            } else {
                players[i] += playerDoRollDiceNum;
                str += "["+(i+1)+"]번 플레이어] 총 점수: ["+playerScoreAddDiceNum+"]점<br>-----------------------------------NEXT TURN--------------------------------------<br>";
            }
        }
        str += "======================================================<br> " +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;📢<<게임 종료!>>" +
                "<br>======================================================<br>" +
                " " + PlayerScore.playerTotalScore(players);
        return str;
    }
}
