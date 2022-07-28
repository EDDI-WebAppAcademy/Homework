package questionBank.javaPractice1.controller;

import questionBank.javaPractice1.entity.Players;
import questionBank.javaPractice1.utillity.CustomRandom;
import questionBank.javaPractice1.utillity.Dice;

import java.util.ArrayList;

public class DiceController {
    private int PLAY_USER_NUM = 3;
    private int START_SCORE = 10;
    private int MIN = 1;
    private int MAX = 6;

    public DiceController() {
    }

    public DiceController(int PLAY_USER_NUM, int START_SCORE) {
        this.PLAY_USER_NUM = PLAY_USER_NUM;
        this.START_SCORE = START_SCORE;

        gameMainController(PLAY_USER_NUM, START_SCORE);
    }

    /**
     * 전체적인 주사위 게임 기능을 컨트롤하는 메서드
     * @param PLAY_USER_NUM 플레이 할 유저의 수
     * @param START_SCORE 기본 점수 설정
     */
    public void gameMainController(int PLAY_USER_NUM, int START_SCORE){
        System.out.println("주사위 게임을 시작합니다");
        System.out.println(PLAY_USER_NUM + "명의 Player 가 생성 되었습니다.");

        //User수 만큼의 ArrayList index 생성 후 기본 점수 부여
        ArrayList<Integer> playersScore = Players.playersScore(PLAY_USER_NUM, START_SCORE);

            for (int i = 0; i < PLAY_USER_NUM; i++) {
                int randomDiceNum = CustomRandom.customRandom(MIN, MAX);
                System.out.println();
                System.out.println("****GAME START!*****");
                System.out.println((i + 1) +"번 Player");

                // 아직 주사위를 돌리지 않았는데 점수가 음수 값으로 떨어진 유저는 0점으로 시작한다.
               if(playersScore.get(i) < 0 ){
                    playersScore.set(i, 0);
                   System.out.println(i + "번 Player 님은 다른 분들의 주사위 기능으로 " +
                           "기본점수를 모두 소진하였기 때문에 0점으로 시작합니다.");
               }
    
                //새롭게 던지는 주사위의 기능
               if(randomDiceNum % 2 == 0){
                   Dice.printRandomNum(randomDiceNum);
                   Dice.scoreControll(playersScore, i, randomDiceNum, 0);
                   Dice.checkSpecialDice(randomDiceNum, playersScore, i);
               }else{
                   Dice.printRandomNum(randomDiceNum);
                    Dice.scoreControll(playersScore, i, randomDiceNum, 0);
           }
            System.out.println();
            System.out.println("현재" + (i + 1)+ " 번 Player 점수 : " + playersScore.get(i));
        }
        System.out.println();
        System.out.println("****GAME END!*****");
        System.out.println(Players.userScoreSum(playersScore));
    }
}
