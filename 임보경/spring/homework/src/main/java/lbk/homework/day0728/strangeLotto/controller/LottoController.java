package lbk.homework.day0728.strangeLotto.controller;

import lbk.homework.day0728.strangeLotto.entity.LottoPlayer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;


@Slf4j
@RestController
@RequestMapping("/strange-lotto")
public class LottoController {

    private List<LottoPlayer> lottoPlayers;
    private Map<Integer, Integer> playersScoreList;
    private List<Integer> winnersList;
    private int lottoPlayerNum;
    private final int LIMIT_LOTTO_PLAYER_NUM = 100;
    private long winnings = 10000000000L;

    @GetMapping("its-a-saturday")
    public String confirmWinning() {
        gatherPlayer();
        selectLotteNum();

        return presentWinners() + "<br> 축하드립니다.";
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



    public String presentWinners() {
        return "당첨자 : " + findPlayerName(checkWinner()) +
                "<br> 당첨금 : " + winningsMoney(checkWinner());
    }
    public long winningsMoney(List<Integer> list) {
        int numberOfWinner = list.size();
        return winnings / numberOfWinner;
    }
    public String findPlayerName(List<Integer> list) {
        String winnersNickname ="" ;
        for (int i = 0; i < list.size(); i++) {
            winnersNickname += lottoPlayers.get(list.get(i)).getName() + " ";
        }
        return winnersNickname;
    }
    public List<Integer> checkWinner() {
        playersScoreList = new HashMap<Integer, Integer>();
        winnersList = new ArrayList<>();

        for (int i = 0; i < lottoPlayerNum; i++) {
            playersScoreList.put(i, lottoPlayers.get(i).getLotto().calFinalNumber());
        }

        Integer maxValue = Collections.max(playersScoreList.values());

        for (int key : playersScoreList.keySet()) {
            int value = playersScoreList.get(key);

            if (value == maxValue) {
                winnersList.add(key);
            }
        }
        return winnersList;
    }

}