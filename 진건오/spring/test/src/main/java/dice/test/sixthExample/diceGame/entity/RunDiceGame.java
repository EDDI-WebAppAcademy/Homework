package dice.test.sixthExample.diceGame.entity;

import dice.test.fifthExample.third.entity.CreateRandom;

public class RunDiceGame {
    private final int numberOfPlayers;
    private final int startPlayersScore;
    private static final int penalty_Value_For_Dice_Number_5 = 2;
    private static final int penalty_Value_For_Dice_Number_3 = 3;
    private static int DICE_NUM_MAX = 6;
    private static int DICE_NUM_MIN = 1;
    static int reCreateDiceNum = 0;

    public RunDiceGame(int numberOfPlayers, int startPlayersScore) {
        this.numberOfPlayers = numberOfPlayers;
        this.startPlayersScore = startPlayersScore;
    }

    public static String startDiceGame(int numberOfPlayers, int startPlayersScore) {
        String str = " ";
        str = "<br>======================================================<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                "📢플레이어 ["+numberOfPlayers + "] 명이 게임에 참가하였습니다. " +
                "<br>======================================================<br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                "📢<<게임을 시작합니다>>" +
                "<br>======================================================<br>" ;

        int[] players = PlayerSetting.playerScoreSetting(numberOfPlayers, startPlayersScore);

        for (int i = 0; i < numberOfPlayers; i++) {
            int playerDoRollDiceNum = CreateRandom.makeToCreateRandom(DICE_NUM_MAX, DICE_NUM_MIN);
            str += "[" + (i+1) + "번 플레이어] : > 주사위 수" + playerDoRollDiceNum+"<br>총점 " + (players[i]+playerDoRollDiceNum) + "점,<br> ";

            if (players[i] <= 0) {
                players[i] = 0;
                str += "[" + (i+1) + "번 플레이어] 가 모든 점수를 소진하여 0점입니다." +
                        "-----------------------------------NEXT TURN--------------------------------------";
            }


            if (playerDoRollDiceNum % 2 == 0) {
                reCreateDiceNum = CreateRandom.makeToCreateRandom(DICE_NUM_MAX, DICE_NUM_MIN);
                players[i] += reCreateDiceNum;
                str += "[" +(i + 1) + "번 플레이어] 는 첫번째 주사위를 굴렸을 때 짝수가 나와 다시 주사위를 돌립니다.<br>[다시 굴렸을때 나오는 주사위 값은 ["+reCreateDiceNum+"]입니다].<br>" +
                        "-----------------------------------NEXT TURN--------------------------------------<br>";

                switch (reCreateDiceNum) {
                    case 1 -> {
                        for (int j = 0; j < numberOfPlayers; j++) {
                            players[j] = players[j] - 2;

                        }
                        str += "주사위가 1이 나와 모든 플레이어의 점수가 -2씩 감점됩니다.<br>" +
                                "<br>-----------------------------------NEXT TURN--------------------------------------<br>";
                    }
                    case 3 -> {
                        players[i] += ((numberOfPlayers - 1) * penalty_Value_For_Dice_Number_3);
                        for (int j = 0; j < numberOfPlayers; j++) {
                            if (j == i) {
                                continue;
                            }
                            players[j] += (players[j] - penalty_Value_For_Dice_Number_3);

                        }
                        str += "주사위 3이 나와 현재 플레이어에게 3점씩 넘겨줍니다.<br>" +
                                "<br>-----------------------------------NEXT TURN--------------------------------------<br>";
                    }
                    case 4 -> {
                        players[i] = 0;
                        str += "주사위 숫자가 4가 나와 [" + (i+1) + "번 플레이어]는 모든 점수를 잃게 되어 게임에서 졌습니다.<br>" +
                                "<br>-----------------------------------NEXT TURN--------------------------------------<br>";
                    }
                    case 5 -> {
                        players[i] -= ((numberOfPlayers - 1) * penalty_Value_For_Dice_Number_5);
                        for (int j = 0; j < numberOfPlayers; j++) {
                            if (j == i) {
                                continue;
                            }
                            players[j] += (players[j] + penalty_Value_For_Dice_Number_5);
                        }
                    }
                }

            } else {
                players[i] += playerDoRollDiceNum;
                str += "[" + (i+1) + "번 플레이어] 주사위 숫자 : [" + playerDoRollDiceNum + "]<br>-----------------------------------NEXT TURN--------------------------------------<br>";
            }
        }
        str += "======================================================<br> " +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;📢<<게임 종료!>>" +
                "<br>======================================================<br>" +
                " " + PlayerScore.playerTotalScore(players);
        return str;
    }
}
