package lbk.homework.day0730.pokerGame.controller;


import lbk.homework.day0728.strangeLotto.entity.LottoPlayer;
import lbk.homework.day0730.pokerGame.entity.PokerGamer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static lbk.homework.day0730.pokerGame.utility.Card.divideCard;
import static lbk.homework.day0730.pokerGame.utility.Card.shuffleCard;

@Slf4j
@RestController
@RequestMapping("/poker")
public class PokerGameController {

    private List<PokerGamer> pokerGamers;
    private int numOfPlayer;
    private final int DEFAULT = 2;


    @GetMapping("game-start")
    public String pokerGame() {

        matchingPlayer(); // 플레이어 모집
        shuffleCard(); // 셔플 카드
        divideCard(numOfPlayer); //

//        GameStart();

        return "게임 결과 : " ;

    }



    public void matchingPlayer() {
        pokerGamers = new ArrayList<>();

        this.numOfPlayer = DEFAULT;
        createPlayerObj(pokerGamers, numOfPlayer);
    }

    private void createPlayerObj(List<PokerGamer> pokerGamers, int numOfPlayer) {
        for (int i = 0; i < numOfPlayer; i++) {
            pokerGamers.add(new PokerGamer());
        }
    }
}
