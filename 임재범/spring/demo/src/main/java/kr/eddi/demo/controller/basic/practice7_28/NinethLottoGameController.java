package kr.eddi.demo.controller.basic.practice7_28;

import kr.eddi.demo.entity.basic.practice7_28.LottoCardManager;
import kr.eddi.demo.entity.basic.practice7_28.Player;
import kr.eddi.demo.entity.basic.practice7_28.WinnerManager;
import kr.eddi.demo.utility.basic.practice7_28.Score;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/nineth")
public class NinethLottoGameController {

    private List<Player> players;
    private LottoCardManager lottoManager;
    private final int MAX_PLAYER = 100;
    private Score scoreManager;
    private WinnerManager winnerManager;

    @GetMapping("/lotto-game")
    public String lottoGame() {
        log.info("lottoGame()");

        allocPlayer(); //플레이어를 할당할 ArrayList를 만듦.
        lottoManager = new LottoCardManager(players.size());//플레이어의 수 만큼의 크기를 갖는 cards라는 ArrayList의 할당.(로또카드가 담길곳)
        lottoManager.allocLottoCardNumber();//그 로또카드에 로또번호를 할당해줌.

        for (int i = 0; i < players.size(); i++) {
            players.get(i).acquireLottoCard(lottoManager, i); //플레이어는 아직 로또카드가 없다. 번호가 적힌 로또카드를 나누어주는과정.
        }

        //scoreManager = new ScoreManager(players.size());
        //scoreManager.calcScore(lottoManager);

        winnerManager = new WinnerManager(); //winnerManager객체 생성.
        List winner = winnerManager.sortWinner(players); //플레이어들의 점수를 기준으로 정렬.
        winnerManager.doReward(winner); //정렬된 리스트 winner를 받아 승자를 선출.

        return "승자 선출이 완료되었습니다!";
    }

    //이 메서드는 플레이어의 수가 가변적일수 있음을 고려하여 플레이어가 담길 ArrayList를 만듭니다.
    private void allocPlayer() {
        players = new ArrayList<>();

        for (int i = 0; i < MAX_PLAYER; i++) {
            players.add(new Player());
        }
    }
}
