package kr.eddi.demo.entity.basic.fifth;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WinnerFind {
    private int PlayerCnt = 5;
    private int LoopGame = 3;

    private int[] PlayerScore = new int[PlayerCnt];

    DiceGame diceGame = new DiceGame();

//    public String showWinner(){
//        int[] playerScore =diceGame.getPlayerScore();
//
//        boolean winner = false;
//        for (int i = 0; i < playerScore.length; i++) {
//            for (int j = 0; j < playerScore.length; j++) {
//                if(playerScore[i] > playerScore[j]){
//
//                }
//            }
//        }
//
//    }
}
