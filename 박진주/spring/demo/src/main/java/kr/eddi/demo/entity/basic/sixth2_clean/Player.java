package kr.eddi.demo.entity.basic.sixth2_clean;

import kr.eddi.demo.entity.basic.utility.basic.sixth2_clean.company1.Dice;
import lombok.Getter;
@Getter
public class Player {
    private Score score;             // Player 클래스 내의 score 변수는 Score 클래스 정보를 가져와서 담음 (totalScore 변수와 addScore() 메소드)
    private String nickName;

    private final String DEFAULT = "anonymous";

    public Player() {             //플레이어 생성자를 이용해 플레이어 생성시 Score 클래스에서 정보 가져 옴.
                                  // 변수 선언 Score score;  public Players(){ score = new Score(); }
        nickName = DEFAULT;
        score = new Score();       // **** Player 객체가 생성될때 player가 가지는 Score 객체도 함께 생성시키는 것! ****
    }

    // 플레이어 클래스 형태의 players[] 베열을 가져옴 -> Player[] players 와 동일 의미
    // Player[] players = new Player[5]; -> 5개의 Player 클래스 변수 값을 이용한 players[5] 배열 생성



    /**(1)gameStart() 메소드  - controller의 gameStart() 메소드 내에서 사용됨
     * 사용자가 게임을 시작해서 주사위를 굴리고 / 굴린 주사위가 짝수라면
     * 앞서 만든 유틸리티 사용하고/ 유틸리티를 사용해서 각 플레이어들에게 옵션 적용
     */

//수정된 코드
    public void gameStart(Player players[]) {
            int diceNum = Dice.rollDice();                        //Dice 클래스의 rolldice() 메소드 사용(해당 메소드는 Static - 유틸리티의 경우 보통 언제든 사용하는 static으로 구성!)
            score.addScore(diceNum);                              //첫번째 주사위 결과 Score 클래스의 addScore()로 넘겨줌

            if (diceNum % 2 == 0) {                                 // 첫번째 주사위 결과 짝수면
                diceNum = Dice.rollDice();                         // 다시 단순 주사위 메소드 실행
                score.addScore(diceNum);                              // score에 두번째 값 결과 더해주도록 값 넘김  (즉,여전히 1명의 플레이어의 주사위중임- 첫번째 결과 + 두번째 결과)
                                                                      // 파라미터 (Player player[], int diceNum, int playerIdx) 객체 정보 필요함
            }

        for (int i = 0; i < players.length; i++) {            // for문 돌려서 왜 플레이어 수만큼 객체 생성해서 반복하는거지??
            Dice specialDice = new Dice();                        // Dice 클래스 받는 specialDice 객체 생성
            specialDice.checkSpecialDice(players, diceNum, i);    //생성한 specialDice에 대해 Dice 클래스의 특수 주사위 checkSpecialDice() 메소드 실행
        }
    }
}

//수정전 코드
//
//    public void gameStart(Player players[]) {                      //어차피 player 개별에 대해 돌아가는 메소드일텐데 여기서 for문은 왜 하는 걸까?
//        for (int i = 0; i < players.length; i++) {                //-> 마지막 checkSpecialDice 메소드에서 i값을 전달하기 위함??
//            int diceNum = Dice.rollDice();                        //Dice 클래스의 rolldice() 메소드 사용(해당 메소드는 Static)
//            score.addScore(diceNum);                              //첫번째 주사위 결과 Score 클래스의 addScore()로 넘겨줌
//
//            if (diceNum % 2 == 0) {                                 // 첫번째 주사위 결과 짝수면
//                diceNum = Dice.rollDice();                         // 다시 단순 주사위 메소드 실행
//                Dice specialDice = new Dice();                     // Dice 클래스 받는 specialDice 객체 생성
//                score.addScore(diceNum);                              // score에 두번째 값 결과 더해주도록 값 넘김  (즉,여전히 1명의 플레이어의 주사위중임- 첫번째 결과 + 두번째 결과)
//
//                specialDice.checkSpecialDice(players, diceNum, i);    //생성한 특별객체에 대해 Dice 클래스의 특수 주사위 checkSpecialDice() 메소드 실행
//                // 파라미터 (Player player[], int diceNum, int playerIdx) 객체 정보 필요함
//            }
//        }
//    }
//}