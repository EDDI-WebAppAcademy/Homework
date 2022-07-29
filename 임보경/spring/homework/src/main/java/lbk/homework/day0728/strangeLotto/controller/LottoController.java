package lbk.homework.day0728.strangeLotto.controller;

import lbk.homework.day0728.strangeLotto.entity.LottoPlayer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;


@Slf4j
@RestController
@RequestMapping("/strange-lotte")
public class LottoController {

    private List<LottoPlayer> lottoPlayers;
    private Map<Integer, Integer> winner;
    private int lottoPlayerNum;
    private final int LIMIT_LOTTO_PLAYER_NUM = 100;

    @GetMapping("its-a-saturday")
    public String confirmWinning() {
        gatherPlayer();
        selectLotteNum();
        findPlayerName(checkWinner());

        return findPlayerName(checkWinner()) + "가 100억에 당첨됬습니다." ;

    }

    public void gatherPlayer() {
        lottoPlayers = new ArrayList<>();

        this.lottoPlayerNum = LIMIT_LOTTO_PLAYER_NUM;
        createPlayerObj(lottoPlayers, lottoPlayerNum);
    }
    private void createPlayerObj(List<LottoPlayer> lottoPlayers, int lottoPlayerNum) {
        for (int i = 0; i < lottoPlayerNum; i++) {
            lottoPlayers.add(new LottoPlayer(i));
        }
    }
    public void selectLotteNum() {
        for (int i = 0; i < lottoPlayerNum; i++) {
            lottoPlayers.get(i).getLotto().perfectNumber();

            //제로 처리 임시방편
            if (lottoPlayers.get(i).getLotto().getSixNumber().get(5) == 0) {
                lottoPlayers.get(i).getLotto().getSixNumber().add(5, -1);
            }

            log.info(lottoPlayers.get(i).getLotto().getSixNumber().toString());
        }
    }
    public int checkWinner() {
        winner = new HashMap<Integer, Integer>();

        for (int i = 0; i < lottoPlayerNum; i++) {
            winner.put(i, lottoPlayers.get(i).getLotto().calFinalNumber());
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
        return lottoPlayers.get(playerIdx).getName();
    }
}
