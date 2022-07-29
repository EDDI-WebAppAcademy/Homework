package kr.eddi.homework.controller.eighth;

import kr.eddi.homework.entity.eighth.Player;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/homework8")
public class SpecialLottoSystemController {
    private final int DEFAULT_PLAYER_NUM = 100;
    private List<Player> players;
    private int playerNum;

    @GetMapping("/special-lotto-system")
    public String lottoStarter(){
        createPlayer();
        lottoStart();
        return checkWinner();
    }

    public void createPlayer(){
        players = new ArrayList<>();
        this.playerNum = DEFAULT_PLAYER_NUM;

        createPlayerObj(players, DEFAULT_PLAYER_NUM);
    }

    public void createPlayerObj(List<Player> players, int playerObjNum){
        for (int i = 0; i < playerObjNum; i++) {
            players.add(new Player());
        }
    }

    public void lottoStart(){
        for (int i = 0; i < playerNum; i++) {
            players.get(i).lottoStart(players);
        }
    }

    public String checkWinner(){
        log.info("정렬 전 : " + String.valueOf(players));

        Collections.sort(players);

        log.info("정렬 후 : " + String.valueOf(players));

        int maxPlayerScore = acquirePlayerScore(playerNum - 1);

        List<Integer> sameScoreIdxList = new ArrayList<>();

        for (int i = playerNum - 2; i >= 0; i--) {
            int tmpScore = acquirePlayerScore(i);

            if (maxPlayerScore == tmpScore) {
                break;
            }
            sameScoreIdxList.add(i);
        }

        if (sameScoreIdxList.size() > 0) {
            return "무승부입니다!";
        }

        return "플레이어: " + players.get(playerNum - 1).getNickname() + "님이 승리하였습니다!";
    }

    public int acquirePlayerScore(int idx){
        return players.get(idx).getScore().getResultScore();
    }

}
