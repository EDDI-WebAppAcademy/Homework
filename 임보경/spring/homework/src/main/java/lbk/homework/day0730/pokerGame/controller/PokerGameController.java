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
        compareCard();

//        GameStart();

        return "게임 결과 : ";

    }

    public void selectTime() {
        for (int i = 0; i < numOfPlayer; i++) {
            System.out.println(pokerGamers.get(i).getName() + "이 공개할 패를 선택합니다.");
            pokerGamers.get(i).selectCard();
        }
    }

    public void dicideTurn() {
        int resultCompare = compareCard();

        if (resultCompare == 1) {
            System.out.println(pokerGamers.get(0).getName() + "이 우선 진행합니다.");
        } else if (resultCompare == 0) {
            int result2Compare = compareShape(); //문양비교

            if (result2Compare == 1) {
                System.out.println(pokerGamers.get(0).getName() + "이 우선 진행합니다.");
            }else if (resultCompare == 0) {
                System.out.println("이 코드 문제있음");
            } else {
                System.out.println(pokerGamers.get(1).getName() + "이 우선 진행합니다.");
            }

        } else {
            System.out.println(pokerGamers.get(1).getName() + "이 우선 진행합니다.");
        }
    }

    public int compareShape() {
        int currentRound = round.getCurrentRound();
        List <CardShape> forCompareShape = new LinkedList<>();
        // test

        for (int i = 0; i < numOfPlayer; i++) {
            String tmpCard = pokerGamers.get(i).getHand().getOpenCards().get(currentRound);
            String splitTmpCard[] = tmpCard.split(":");
            String tmp = splitTmpCard[0];
            CardShape cardShape = CardShape.valueOf(tmp);
            forCompareShape.add(i, cardShape);
        }

        return forCompareShape.get(0).compareTo(forCompareShape.get(1));
    }

    public int compareCard() {
        int currentRound = round.getCurrentRound();
        List <CardNumber> forCompareNumber = new LinkedList<>();
        // test

        for (int i = 0; i < numOfPlayer; i++) {
            String tmpCard = pokerGamers.get(i).getHand().getOpenCards().get(currentRound);
            String splitTmpCard[] = tmpCard.split(":");
            String tmp = splitTmpCard[1];
            CardNumber cardNumber = CardNumber.valueOf(tmp);
            forCompareNumber.add(i, cardNumber);
        }

        return forCompareNumber.get(0).compareTo(forCompareNumber.get(1));
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
