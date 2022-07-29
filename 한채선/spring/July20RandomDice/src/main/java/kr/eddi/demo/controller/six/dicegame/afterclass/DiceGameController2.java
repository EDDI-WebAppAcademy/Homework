package kr.eddi.demo.controller.six.dicegame.afterclass;

import kr.eddi.demo.entity.six.dicegame.Player;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/seventh")
public class DiceGameController2 {

    private final int DEFAULT_PLAYER_NUM = 2;
    private final int GAME_IS_OVER = 4;
    private ArrayList<Player> players;
    private int playerNum;

    @GetMapping("/dice-game-starter")
    public String diceGameStarter() {
        createPlayer();
        gameStart();

        return checkWinner();
    }


    private void createPlayer() {

        players = new ArrayList<>();
        this.playerNum = DEFAULT_PLAYER_NUM;

        createPlayerObj(players, DEFAULT_PLAYER_NUM);
    }

    private void createPlayer(int playerNum) {
        players = new ArrayList<>();
        this.playerNum = playerNum;

        createPlayerObj(players, playerNum);
    }

    private void createPlayerObj(ArrayList<Player> players, int playerObjectNum) {
        for (int i = 0; i < playerObjectNum; i++) {
            players.add(new Player());
        }
    }

    /**
     * 사용자가 게임을 시작하면 주사위를 굴리고, 굴린 주사위가 짝수라면 앞서 만든 다이스 스킬 유틸리티를 사용하여 각 플레이어들에게 옵션을 적용하는 메서드
     */
    private void gameStart() {
        for (int i = 0; i < playerNum; i++) {
            players.get(i).gameStart(players);
        }
    }

    private String checkWinner() {
        /* 기본적으로 java는 String 에 대한 처리르 서포트하지만
           사용자 커스텀 자료타입인 class에 대해서는 부가적 작업을 요구한다


         */

        log.info("정렬 전:" + String.valueOf(players));

        Collections.sort(players);

        log.info("정렬 후: " + String.valueOf(players));



        int maxPlayerScore = acquirePlayerTotalScore(playerNum - 1);

        if (maxPlayerScore == GAME_IS_OVER) {
            return "전원 탈락!";
        }

        List<Integer> sameScoreIdxList = new ArrayList<>();

        for(int i = playerNum - 2; i >= 0; i--) {
            int tmpScore = acquirePlayerTotalScore(i);

            if (maxPlayerScore != tmpScore) { break; }

            sameScoreIdxList.add(i);
        }

        if(sameScoreIdxList.size() > 0) {
            return "무승부입니다!";
        }

        return "플레이어 " + players.get(playerNum-1).getNickName() + "님이 승리하였습니다!";

    }

    public int acquirePlayerTotalScore(int idxNum) {
        return players.get(idxNum).getScore().getTotalScore();
    }
}
