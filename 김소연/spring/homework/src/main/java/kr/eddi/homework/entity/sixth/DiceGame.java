package kr.eddi.homework.entity.sixth;


/*
 *총 2개의 주사위를 굴릴 수 있다.
 * 첫 번째 주사위를 굴려서 짝수가 나왔다면 주사위를 한 번 더 굴릴 수 있다.
 *
 * 새롭게 한 번 더 굴리는 주사위에는 특수 기능들이 달려 있다.
 *
 * 숫자 4가 나오는 경우 즉시 게임 오버된다.
 * 숫자 3이 나오는 경우엔 친구들 주사위에서 점수를 3점씩 뺏어올 수 있다.
 * 숫자 5가 나오는 경우엔 자신의 점수를 2점씩 친구들에게 나눠줘야 한다.
 * 숫자 1의 경우엔 모두 다 함께 -2점씩 감점된다.
 * 예외 사항으로 이미 0점인 친구 혹은 아직 주사위를 굴리지 않았다면 음수값을 가지지 않고 0점을 유지한다
 *  합산값이 높은 사람이 이기도록 게임을 만들자
 * */

import lombok.AllArgsConstructor;

import java.util.ArrayList;


@AllArgsConstructor
public class DiceGame {
    private final int playerNum;

    private static final int MAX = 6;
    private int[]  playerArr;
    private static final int LOSEPOINT = 2;
    private static final int GETPOINT = 3;


    public DiceGame(int playerNum){
        this.playerNum = playerNum;
    }

    public static String runDiceGame(int playerNum){
        String msg = "";

        msg = "게임을 시작합니다." + "<br>";

        for (int i = 1; i <= playerNum; i++) {
            int firstScore = Dice.rollDice(MAX);
            ArrayList<Integer> players = Player.players(playerNum,firstScore);
            msg += i + "번 플레이어 주사위 결과 : " + firstScore + "<br>";

            if(firstScore % 2 == 0){
                msg += "짝수가 나와 주사위를 한번 더 굴립니다." + "<br>";
                int secondScore = Dice.rollDice(MAX);
                msg += "두번째 주사위 결과 : " + secondScore + "<br>";

                switch (secondScore){
                    case 1:
                        return msg + "모두 다 함께 -2점씩 감점됩니다. 결과 : " + (firstScore - LOSEPOINT);
                    case 3:
                        return msg + "친구들 주사위에서 점수를 3점씩 뺏어옵니다. 결과 : " + (firstScore + GETPOINT * playerNum);
                    case 5:
                        return msg + "점수를 2점씩 친구들에게 나눠줍니다. 결과 : " + (firstScore - LOSEPOINT * playerNum);
                    case 4:
                        return msg + "GAME OVER";
                }
            }
        }
        return msg;
    }

}
