package kr.eddi.demo.controller.basic.sixth;

import kr.eddi.demo.entity.basic.sixth.clean.Player;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/sixth-clean")
public class SixthCleanDiceGameController {
    private final int DEFAULT_PLAYER_NUM = 2;
    private Player[] players;
    private int playerNum; //게임 참여자 수

    @GetMapping("/dice-game-starter")
    public String diceGameStarter() {

        createPlayer();
        gameStart();

        return checkWinner();
    }

    public void createPlayer() {
        players = new Player[DEFAULT_PLAYER_NUM];
        this.playerNum = DEFAULT_PLAYER_NUM;

        createPlayerObj(players, DEFAULT_PLAYER_NUM);
    }

    public void createPlayer(int playerNum) {
        players = new Player[playerNum];
        this.playerNum = playerNum;

        createPlayerObj(players, playerNum);
    }

    public void createPlayerObj(Player player[], int playerObjNum) {
        for (int i = 0; i < playerObjNum; i++) {
            player[i] = new Player(); // 생성자 기능 확인하기 !! 헷갈림!!
        }
    }

    //사용자가 게임을 시작해서
    // 주사위를 굴리고
    // 굴린 주사위가 짝수라면
    // 앞서 만든 유틸리티 사용하고
    // 유틸리티를 사용해서 각 플레이어들에게 옵션 적용.
    public void gameStart() {
        for (int i = 0; i < playerNum; i++) {
            // 각 플레이어가 게임 실행하는 기능
            players[i].gameStart(players);
        }
    }

    // 최종 승자 판정
    // 현재 이 부분은 일반화하지 않았고 2명이라 가정하고 진행함.
    // 실제로는 Collection에 넣고 sort() 시키면 정렬이 됨.
    // 여기선 그냥 두명 가정하고 만듦.
    public String checkWinner() {
        int playerScore1 = players[0].getScore().getTotalScore();
        int playerScore2 = players[1].getScore().getTotalScore();

        if (playerScore1 > playerScore2) {
            return "플레이어 1 승리!";
        } else if (playerScore1 < playerScore2) {
            return "플레이어 2 승리!";
        } else {
            return "무승부!";
        }
    }
}
