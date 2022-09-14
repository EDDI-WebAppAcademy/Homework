package lbk.homework.day0730.pokerGame.controller;


import lbk.homework.day0730.pokerGame.entity.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;


@Slf4j
@RestController
@RequestMapping("/poker")
public class PokerGameController {

    private List<PokerGamer> pokerGamers;
    private Card card;
    private Round round;
    private int numOfPlayer;
    private final int DEFAULT = 2;


    @GetMapping("game-start")
    public String pokerGame() {
        startSetting();
        manageDivideCard();
        selectTime();


//        GameStart();

        return "게임 결과 : ";

    }

    public void selectTime() {
        for (int i = 0; i < numOfPlayer; i++) {
            System.out.println(pokerGamers.get(i).getName() + "이 공개할 패를 선택합니다.");
            pokerGamers.get(i).selectCard();
        }
    }



    public void manageDivideCard() {
        int currentRound = round.getCurrentRound();

        if (currentRound == 0) {

            for (int cardCnt = 0; cardCnt < 3; cardCnt++) {
                divideCard(card.getCardPack());
            }

        } else {
            divideCard(card.getCardPack());
        }
    }


    public void divideCard(List shuffledCardPack) { // 한장씩 나누기
        for (int gamerIdx = 0; gamerIdx < numOfPlayer; gamerIdx++) {
            pokerGamers.get(gamerIdx).getHand().getCardOnHand().add((String) shuffledCardPack.get(0));
            shuffledCardPack.remove(0);

            log.info(pokerGamers.get(gamerIdx).getName() + pokerGamers.get(gamerIdx).getHand().getCardOnHand().toString());
        }
    }

    public void matchingPlayer() {
        pokerGamers = new ArrayList<>();
        this.numOfPlayer = DEFAULT;

        for (int i = 0; i < numOfPlayer; i++) {
            pokerGamers.add(new PokerGamer(i));
        }
    }

    public void startSetting() {
        matchingPlayer(); // 플레이어 모집
        card = new Card();
        round = new Round();
        // 라운드 세팅
        System.out.println("현재 라운드 " + round.getCurrentRound() + 1);
    }


}
