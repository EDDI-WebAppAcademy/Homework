package questionBank.javaPractice1.controller;

import questionBank.javaPractice1.entity.PlayUser;
import questionBank.javaPractice1.utillity.CustomRandom;

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
        System.out.println(PLAY_USER_NUM + "명의 user가 생성 되었습니다.");

        //User수 만큼의 ArrayList index 생성 후 기본 점수 부여
        ArrayList<Integer> userNum = PlayUser.playUserNum(PLAY_USER_NUM, START_SCORE);

            for (int i = 0; i < PLAY_USER_NUM; i++) {
            int randomDiceNum = CustomRandom.customRandom(MIN, MAX);
            System.out.println();
            System.out.println("****GAME START!*****");
            System.out.println((i + 1) +"번 user");

            // 다른 유저의 점수 때문에 점수가 마이너스로 떨어진 유저는 0점으로 시작한다.
           if(userNum.get(i) < 0 ){
                userNum.set(i, 0);
               System.out.println(i + "번 user님은 다른 user분들의 기능으로 기본점수를 소진하였기 때문에 0점으로 시작합니다.");
            }

            //새롭게 던지는 주사위의 기능
           if(randomDiceNum % 2 == 0){
               System.out.println("짝수"+ randomDiceNum +"(이)가 나왔습니다. 주사위를 한 번 더 던집니다.");
               userNum.set(i, userNum.get(i) + randomDiceNum);

               switch (randomDiceNum){
                   case 1 :
                        System.out.println("1이 나왔습니다.");
                        System.out.println("모두 다 함께 -2점씩 감점됩니다.");
                        userNum.set(i, userNum.get(i) - 2);
                            for (int j = 0; j < PLAY_USER_NUM; j++) {
                                if(i == j){
                                    continue;
                                }
                                userNum.set(j, userNum.get(j) - 2);
                            }
                            break;
                   case 2 :
                        System.out.println("짝수 2가 나왔습니다. 주사위를 다시 돌립니다.");
                        userNum.set(i, userNum.get(i) + 2);
                   case 3 :
                        System.out.println("3이 나왔습니다. 다른 유저의 점수를 3점씩 뺏어옵니다.");
                        userNum.set(i, userNum.get(i) + 3);
                            for (int j = 0; j < PLAY_USER_NUM; j++) {
                                if(i == j){
                                    continue;
                                }
                                userNum.set(j, userNum.get(j) - 3);
                            }
                        break;
                   case 4 :
                        System.out.println("4가 나왔습니다. 바로 탈락됩니다.");
                        userNum.set(i, 0);
                        break;
                   case 5:
                        System.out.println("5가 나왔습니다. 내 점수를 다른 유저들에게 5점씩 나눠줍니다.");
                        userNum.set(i, userNum.get(i) + 5);
                            for (int j = 0; j < PLAY_USER_NUM; j++) {
                                if(i == j){
                                    continue;
                                }
                                userNum.set(j, userNum.get(j) + 5);
                            }
                        break;
                   case 6:
                        System.out.println("짝수 6이 나왔습니다. 주사위를 다시 돌립니다.");
                        userNum.set(i, userNum.get(i) + 6);
                }
           }else{
                System.out.println("주사위 값 : " + randomDiceNum);
                userNum.set(i, userNum.get(i) + randomDiceNum);
           }
            System.out.println();
            System.out.println("현재" + (i + 1)+ "번 유저 점수 : " + userNum.get(i));
        }
        System.out.println();
        System.out.println("****GAME END!*****");
        System.out.println(PlayUser.userScoreSum(userNum));
    }
}
