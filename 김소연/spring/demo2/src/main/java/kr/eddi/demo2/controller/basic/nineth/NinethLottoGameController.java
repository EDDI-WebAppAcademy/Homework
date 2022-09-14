package kr.eddi.demo2.controller.basic.nineth;

import kr.eddi.demo2.entity.nineth.LottoCardManager;
import kr.eddi.demo2.entity.nineth.Player;
import kr.eddi.demo2.utility.nineth.Score;
import kr.eddi.demo2.entity.nineth.WinnerManager;
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

    @GetMapping("lotto-game")
    public String lottoGame(){
        log.info("lottoGame()");

        alloPlayer();
        lottoManager = new LottoCardManager(players.size()); //사이즈 전달 사용된 숫자만큼 로또 만들거.
        lottoManager.allocLottoCardNumber(); //카드번호 만들기

        for (int i = 0; i < players.size(); i++) {
        //플레이어 사이즈만큼 가져와서 //플레이어 정보가져오고/어콰이어로또카드하고 매니저를 던져
            players.get(i).acquireLottoCard(lottoManager, i); //현재 사용자의 인덱스
        }

        winnerManager = new WinnerManager();
        List winner = winnerManager.sortWinner(players);
        winnerManager.doReward(winner);

        return "승자 선출이 완료되었습니다!";
    }

    //플레이어 할당 마무리
    private void alloPlayer(){//외부에 공개하진 않을거니까
        players = new ArrayList<>();
        for (int i = 0; i < MAX_PLAYER; i++) {
            players.add(new Player());
        }
    }
}
