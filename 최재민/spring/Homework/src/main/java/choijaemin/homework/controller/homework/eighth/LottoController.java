package choijaemin.homework.controller.homework.eighth;

import choijaemin.homework.entity.eighth.Player;
import choijaemin.homework.utility.eighth.DrawLottoNum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/eigth")
public class LottoController {

    private List<Player> players;
    private final int DEFAULT_PLAYER_NUM = 100;
    private int playerNum;

    private final int DEATH_SCORE = -9999;
    private final int DRAWCNT = DrawLottoNum.setDrawCnt();
    private long prizeMoney = 1000000000L;
    @GetMapping("/Lotto")
    public String LottoStarter(){
        log.info("로또 추첨을 시작합니다.");
        createPlayer();

        drawLottoNum();

        checkOverlapNum();

        calLottoNum();

        return checkWinner();
    }


    public void createPlayer(){
        players = new ArrayList<>();
        this.playerNum = DEFAULT_PLAYER_NUM;
        createPlayerObj(players, DEFAULT_PLAYER_NUM);
    }

    public void createPlayerObj(List<Player> players, int playerObjNum) {
        for (int i = 0; i < playerObjNum; i++) {
            players.add(new Player());
        }
    }
    public void drawLottoNum() {
        for (int i = 0; i < playerNum; i++) {
            players.get(i).drawLottoNum(players);
        }
    }

    public void checkOverlapNum(){
        int reDrawNum;
        boolean checkOverLap = true;
        for (int k = 0; k < DRAWCNT; k++) {

            for (int i = 0; i < players.size(); i++) { // 비교 하는 애
                int compareTarget = players.get(i).getScore().getLotteryNum().get(k);

                for (int j = i+1; j <players.size()-1; j++) { // 비교 당하는 애들
                    int comparedTarget = players.get(j).getScore().getLotteryNum().get(k);
                    if (compareTarget == comparedTarget) {
                        reDrawNum = DrawLottoNum.makeLottoNum();
                        players.get(j).getScore().getLotteryNum().set(k,reDrawNum);
                        checkOverLap = false;
                        break;
                    }
                };
                if (checkOverLap == false){
                    i = 0;
                    continue;
                }
            }
        }

    }
    public void calLottoNum() {
        int[] calNum = new int[DRAWCNT];
        int totalScore;

        for (int i = 0; i < players.size(); i++) {
            totalScore = 0;
            for (int j = 0; j < DRAWCNT; j++) {
                calNum[j] = players.get(i).getScore().getLotteryNum().get(j);
            }

            for (int k = 0; k < calNum.length - 2; k++) {
                totalScore += calNum[k];
            }

            totalScore *= calNum[calNum.length - 2];
            totalScore /= calNum[calNum.length - 1];

            if (calNum[DRAWCNT] <= 0) {totalScore = -DEATH_SCORE;}

            players.get(i).getScore().setTotalScore(totalScore);

        }
    }


    public String checkWinner(){

        log.info("정렬전: " + String.valueOf(players));

        Collections.sort(players);

        log.info("정렬후: " + String.valueOf(players));

        int maxPlayerScore = acquirePlayerTotalScore(playerNum -1);

        List<Integer> sameScoreIdxList = new ArrayList<>();

        for (int i = playerNum - 2; i >= 0; i--) {
            int tmpScore = acquirePlayerTotalScore(i);

            if (maxPlayerScore != tmpScore){break;}

            sameScoreIdxList.add(i);
        }

        if (sameScoreIdxList.size() > 0){
            int SameScoreCnt = sameScoreIdxList.size();
            int dividePrizeMoney = (int)prizeMoney/SameScoreCnt;
            return SameScoreCnt+"명의 동점자가 발생하여 상금을"+dividePrizeMoney+"원으로 나누어 지급합니다.";
        }
        return players.get(playerNum - 1).getNickName() + "님이 승리하셨습니다. 상급" +prizeMoney +"원을 지급합니다.";
    }

    public int acquirePlayerTotalScore(int idx) {
        return players.get(idx).getScore().getTotalScore();
    }
}
