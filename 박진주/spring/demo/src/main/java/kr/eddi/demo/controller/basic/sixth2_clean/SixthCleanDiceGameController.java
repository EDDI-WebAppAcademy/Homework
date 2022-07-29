package kr.eddi.demo.controller.basic.sixth2_clean;

import kr.eddi.demo.entity.basic.sixth2_clean.Player;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/sixth-clean")
public class SixthCleanDiceGameController {

    private final int DEFAULT_PLAYER_NUM = 2;  // 플레이어 수 2명
    private Player[] players;      // 플레이어 클래스를 받는 객체배열 players
    private int playerNum;        //플레이어 번호


    /**(1) 최종 실행 diceGameStarter() 메소드
     * url 실행되면 플레이어 생성(createPlayer()) + 게임스타트 메소드(gameStart()) 실행   - 리턴 값으로 checkWinner() 메소드 받음
     */

    @GetMapping("/dice-game-starter")
    public String diceGameStarter() {

        createPlayer();
        gameStart();

        return checkWinner();
    }


    /**(2) createPlayer() 플레이어 생성 메소드 - 큰틀의 플레이어 객체 생성용
     * -> 디폴트 넘버를 갖는 경우와 int PlayerNum을 지정할 수 있는 경우 2개로 overloading
     * Player players = new Player[2] -> 플레이어 클래스를 받는 객체 배열 생성
     * 플레이어 수 = 2 할당
     */

    public void createPlayer() {
        players = new Player[DEFAULT_PLAYER_NUM]; // 여기서 players 만든 이유는 아래 createPlayerObj()에서 파라미터로 player[] 배열을 받기때문에 실제 인자를 넣어주기 위함
        this.playerNum = DEFAULT_PLAYER_NUM;

        createPlayerObj(players, DEFAULT_PLAYER_NUM);
    }

    public void createPlayer(int playerNum) {
        players = new Player[playerNum];
        this.playerNum = playerNum;

        createPlayerObj(players, playerNum);
    }


    /** (3) createPlayerObj() 메소드    - 실제 i번째 작은 틀의 플레이어 객체 생성용
     * for문 이용해서 실제 객체 만들어줌. player[0], player[1]... 생성됨
     * (위 createPlayer() 메소드에서 비슷하게 players = new Player[DEFAULT_PLAYER_NUM] 한건 파라미터에 넣어줄 객체배열 값 생성을 위한 것임 )
     * 파라미터(인자)로 player 배열값, playerObjNum 받음
     * -> playerObjNum는 이 메소드에서만 만들어 숫자 개념으로 사용한 것으로 실제 사용시 PlayerNum, DEFAULT_PLAYER_NUM으로 대체됨
     */


    public void createPlayerObj(Player player[], int playerObjNum) {
        for (int i = 0; i < playerObjNum; i++) {
            player[i] = new Player();
        }
    }

    /**(4) gameStart() 메소드
     * 해당 소스코드엔 gameStart() 메소드가 2개 존재.
     * 이 메소드는 실제 player[0], player[1]..에게 Player 클래스에 있는 gameStart() 메소드 적용해주는 메소드임
     */

    public void gameStart() {                        // 해당 메소드는 최종 url 맵핑 시 실행되는 gameStart() 메소드
        for (int i = 0; i < playerNum; i++) {
            players[i].gameStart(players);           // 실제 내부에서 사용되는 gameStart()메소드는 Player 클래스의 메소드임
        }                                            // 배열[i].메소드(); 형태 기억해둘 것 - player[0], player[1],, 실제 객체 개별에 대한 메소드 실행
    }

    /**
     * 사용자별로 게임을 시작해서                              -> sixthCleanDiceGameController.gameStart() 메소드에서 동작
     * 주사위를 굴리고 / 굴린 주사위가 짝수라면 /                 -> 이하 뒷부분은 Player.gameStart() 메소드에서 동작
     * 앞서 만든 유틸리티 사용하고 / 유틸리티를 사용해서 각 플레이어들에게 옵션 적용
     */


    /**(5) checkWinner() 메소드
     * 최종 승자 판정
     * 현재 이 부분은 일반화하지 않았고 2명이라 가정하고 진행함
     * 실제로는 Collection에 넣고 sort() 시키면 정렬이 됨
     */

    public String checkWinner() {
        int playerScore1 = players[0].getScore().getTotalScore();
        int playerScore2 = players[1].getScore().getTotalScore();

        if (playerScore1 > playerScore2) {
            return "플레이어 1 승리!";
        } else if (playerScore1 < playerScore2){
            return "플레이어 2 승리!";
        } else {
            return "무승부";
        }
    }
}

 /** 위에 int playerScore1 = players[0].getScore().getTotalScore(); 는 왜 메소드를 두번 연속 사용하였나?
 *  players[0]의 getTotalScore()만 사용하면 되지 않나? 라는 의문이 있었음
  *
 *  -> getScore()는 Player 클래스 내의 score 변수를 의미하며, 해당 변수는 Score score; 로 Score 클래스를 받는 객체변수임
 *  -> getTotalScore()는 Score 클래스 내의 totalScore 변수를 의미하며, 해당변수는 int 값을 가짐
  * -> players[0].Player클래스 메소드().Score클래스 메소드() 형태인 것
  *
  * 각 메소드 단독 사용 안되는 이유
 *  player[0].getScore()는 리턴 값이 Score 객체로 int인 playerScore1과 데이터 형태 맞지 않음
 *  player[0].getTotalScore()는 리턴값이 int이긴 하나 Score 클래스 메소드이기 때문에 플레이어 정보를 관리하지 않음
  *
  * 즉, 플레이어 개별의 토탈 점수를 알기 위해서는 Player 클래스의 getScore() 메소드를 통해 정보를 얻고, Score 클래스의 getTotalScore() 메소드 값을 얻어야 함
 */


/**
 *
 */

