package lbk.homework.day0728.uniqueLotte.controller;

import lbk.homework.day0728.uniqueLotte.entity.LottePlayer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;


@Slf4j
@RestController
@RequestMapping("/strange-lotte")
public class LotteController {

    private List<LottePlayer> lottePlayers;
    private Map<Integer, Integer> winner;
    private int lottePlayerNum;
    private final int LIMIT_LOTTE_PLAYER_NUM = 100;

    @GetMapping("its-a-saturday")
    public String confirmWinning() {
        gatherPlayer();
        selectLotteNum();
        findPlayerName(checkWinner());

        return findPlayerName(checkWinner()) + "가 100억에 당첨됬습니다." ;

    }

    public void gatherPlayer() {
        lottePlayers = new ArrayList<>();

        this.lottePlayerNum = LIMIT_LOTTE_PLAYER_NUM;
        createPlayerObj(lottePlayers, lottePlayerNum);
    }
    private void createPlayerObj(List<LottePlayer> lottePlayers, int lottePlayerNum) {
        for (int i = 0; i < lottePlayerNum; i++) {
            lottePlayers.add(new LottePlayer(i));
        }
    }
    public void selectLotteNum() {
        for (int i = 0; i < lottePlayerNum; i++) {
            lottePlayers.get(i).getLotte().perfectNumber();

            //제로 처리 임시방편
            if (lottePlayers.get(i).getLotte().getSixNumber().get(5) == 0) {
                lottePlayers.get(i).getLotte().getSixNumber().add(5, -1);
            }

            log.info(lottePlayers.get(i).getLotte().getSixNumber().toString());
        }
    }
    public int checkWinner() {
        winner = new HashMap<Integer, Integer>();

        for (int i = 0; i < lottePlayerNum; i++) {
            winner.put(i, lottePlayers.get(i).getLotte().calFinalNumber());
        }

        Integer maxValue = Collections.max(winner.values());
        int winnerPlayer = 0;
        for (int key : winner.keySet()) {
            int value = winner.get(key);

            if (value == maxValue) {
                winnerPlayer = key;
            }
        }
        return winnerPlayer;
    }
    public String findPlayerName(int playerIdx) {
        return lottePlayers.get(playerIdx).getName();
    }
}
