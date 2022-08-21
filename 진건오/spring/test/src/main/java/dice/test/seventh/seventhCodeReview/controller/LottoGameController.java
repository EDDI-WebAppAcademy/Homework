package dice.test.seventh.seventhCodeReview.controller;

import dice.test.seventh.seventhCodeReview.entity.LottoCard;
import dice.test.seventh.seventhCodeReview.entity.LottoCardManager;
import dice.test.seventh.seventhCodeReview.entity.Player;
import dice.test.seventh.seventhCodeReview.entity.WinnerManager;
import dice.test.seventh.seventhCodeReview.utillity.Score;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/nineth")
public class LottoGameController {

    private List<Player> players;
    private LottoCardManager lottoManager;
    private final int MAX_PLAYER = 100;
    private Score scoreManager;
    private WinnerManager winnerManager;

    @GetMapping("/lotto-game")
    public String lottoGame() {

        allocPlayer();
        lottoManager = new LottoCardManager(players.size());
        lottoManager.allocLottoCardNumber();

        for (int i = 0; i < players.size(); i++) {
            players.get(i).acquireLottoCard(lottoManager, i);
        }
        winnerManager = new WinnerManager();
        List winner = winnerManager.sortWinner(players);
        winnerManager.doReward(winner);

        return "승자 선출 완료";
    }

    private void allocPlayer() {
        players = new ArrayList<>();

        for (int i = 0; i < MAX_PLAYER; i++) {
            players.add(new Player());
        }
    }
}
