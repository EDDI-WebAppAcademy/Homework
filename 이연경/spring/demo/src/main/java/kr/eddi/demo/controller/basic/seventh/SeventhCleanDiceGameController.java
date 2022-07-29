package kr.eddi.demo.controller.basic.seventh;



import kr.eddi.demo.entity.basic.seventh.Player;
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
public class SeventhCleanDiceGameController {

    private final int DEFAULT_PLAYER_NUM = 2;
    private final int DEATH_SCORE = -4444;
    private List<Player> players;
    private int playerNum;

    @GetMapping("/dice-game")
    public String diceGameStarter() {

        createPlayer();
        gameStart();

        return checkWinner();
    }

    public void createPlayer() {


        players = new ArrayList<>();
        this.playerNum = DEFAULT_PLAYER_NUM;

        createPlayerObj(players, DEFAULT_PLAYER_NUM);
    }

    public void createPlayerObj(List<Player> players, int playerObjNum) {
        for (int i = 0; i < playerObjNum; i++) {
            players.add(new Player());
        }
    }

    // 사용자가 게임을 시작해서
    // 주사위를 굴리고
    // 굴린 주사위가 짝수라면
    // 앞서 만든 유틸리티 사용하고
    // 유틸리티를 사용해서 각 플레이어들에게 옵션 적용
    public void gameStart() {
        for (int i = 0; i < playerNum; i++) {
            players.get(i).gameStart(players);
        }
    }

    // 최종 승자 판정
    // 현재 이 부분은 일반화하지 않았고 2명이라 가정하고 진행함
    // 실제로는 Collection에 넣고 sort() 시키면 정렬이 됨
    // 여기선 그냥 두명 가정하고 만듭시다.
    // 이거까지 또 일반화하면 ... 머리 터질것 같으니까 ㅋㅋㅋ
    public String checkWinner() {
        // 기본적으로 Java는 String에 대한 처리를 서포트하지만
        // 사용자 커스텀 자료타입인 class에 대해서는 부가적 작업을 해줘야함
        // Collections가 기본적으로 Comparable을 extends 하고 있으며
        // 실제 Comparable은 interface임을 볼 수 있다.
        // 해당 인터페이스는 compareTo 프로토타입을 가지고 있으므로
        // 우리가 정렬하고자 하는 Player 클래스에 이에 대한 구현체가 필요하다.
        log.info("정렬전: " + String.valueOf(players));

        Collections.sort(players);

        log.info("정렬후: " + String.valueOf(players));

        int maxPlayerScore = acquirePlayerTotalScore(playerNum - 1);

        if (maxPlayerScore == DEATH_SCORE) { return "전원 탈락!!!"; }

        List<Integer> sameScoreIdxList = new ArrayList<>();

        for (int i = playerNum - 2; i >= 0; i--) {
            int tmpScore = acquirePlayerTotalScore(i);

            if (maxPlayerScore != tmpScore) { break; }

            sameScoreIdxList.add(i);
        }

        if (sameScoreIdxList.size() > 0) { return "무승부입니다!"; }

        return "플레이어: " + players.get(playerNum - 1).getNickName() + " 님이 승리하였습니다!";
    }

    public int acquirePlayerTotalScore(int idx) {
        return players.get(idx).getScore().getTotalScore();
    }
}
