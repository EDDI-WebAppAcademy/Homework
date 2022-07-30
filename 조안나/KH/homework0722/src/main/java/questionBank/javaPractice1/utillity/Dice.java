package questionBank.javaPractice1.utillity;

import java.util.ArrayList;

public class Dice {

    public static void checkSpecialDice(int randomDiceNum, ArrayList<Integer> playerScore, int playerIdx){

        switch (randomDiceNum){
            case 1 :
                printRandomNum(randomDiceNum);
                System.out.println("모두 다 함께 -2점씩 감점됩니다.");
                scoreControll(playerScore, playerIdx, -2, -2);
                break;
            case 2 :
                printRandomNum(randomDiceNum);
                scoreControll(playerScore, playerIdx, 2, 0);
            case 3 :
                printRandomNum(randomDiceNum);
                System.out.println("다른 유저의 점수를 3점씩 뺏어옵니다.");
                scoreControll(playerScore, playerIdx, 3, -3);
                break;
            case 4 :
                printRandomNum(randomDiceNum);
                System.out.println("바로 탈락됩니다.");
                scoreControll(playerScore, playerIdx, -4444, 0);
                break;
            case 5:
                printRandomNum(randomDiceNum);
                System.out.println("내 점수를 다른 유저들에게 5점씩 나눠줍니다.");
                scoreControll(playerScore, playerIdx, -5, 5);
                break;
            case 6:
                printRandomNum(randomDiceNum);
                scoreControll(playerScore, playerIdx, 6, 0);
        }
    }


    /**
     * 입력 받은 주사위 값에따라 메세지를 프린트해주는 메서드
     * @param randomDiceNum 던진 주사위 값
     */
    public static void printRandomNum(int randomDiceNum) {
        System.out.println("주사위 값 : " + randomDiceNum);
        if(2 == randomDiceNum || randomDiceNum == 6) {
            System.out.println("주사위를 다시 돌립니다.");
        }
    }


    /**
     * 플레이어들의 점수를 컨트롤 하는 메서드
     * @param playerScore 플레이어들의 점수가 담긴 ArrayList
     * @param playerIdx 현재 플레이 중인 플레이어의 INDEX 번호
     * @param myScore 현재 플레이 중인 플레이어의 점수
     * @param otherPlayersScore 현재 플레이 중인 플레이어 외 나머지 플레이어들의 점수
     */
    public static void scoreControll(ArrayList<Integer> playerScore, int playerIdx, int myScore, int otherPlayersScore){
        for (int i = 0; i < playerScore.size(); i++) {
            if (i == playerIdx){
                playerScore.set(i, playerScore.get(i) + myScore);
            }
            playerScore.set(i, playerScore.get(i) + otherPlayersScore);
        }
    }
}
