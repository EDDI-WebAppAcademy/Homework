package kr.eddi.demo.entity.tenth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PokerCard {
    private List<String[]> pokerDeck;
    private String[] playerDeck;
    private String[] computerDeck;

    private final int getCardCount = 7;


    public PokerCard() {
        playerDeck = new String[getCardCount];
        computerDeck = new String[getCardCount];
    }

    public String[] makePlayerCardDeck() {
        String card;
        Random random = new Random();
        String numbers = "23456789TJQKA";
        String marks = "SDHC";


        for (int i = 0; i < getCardCount; i++) {
            char cardNumber = numbers.charAt(random.nextInt(13));
            char cardMark = marks.charAt(random.nextInt(4));
            StringBuilder sb = new StringBuilder();
            card = String.valueOf(sb.append(cardNumber).append(cardMark));    // << 숫자와 모양을 랜덤하게 뽑아 card 생성

            if (Arrays.asList(playerDeck).contains(card)) {
                return makePlayerCardDeck();
            } else {
                playerDeck[i] = card;                         //  << 랜덤한 카드가 플레이어 덱에 중복이 되면
                                                              //  다시 랜덤카드 뽑고 중복이 안되면 배열에 추가
            }
        }
        return playerDeck;
    }

    public String[] makeComputerCardDeck() {
        String card;
        Random random = new Random();
        String numbers = "23456789TJQKA";
        String marks = "SDHC";


        for (int i = 0; i < getCardCount; i++) {
            char cardNumber = numbers.charAt(random.nextInt(13));
            char cardMark = marks.charAt(random.nextInt(4));
            StringBuilder sb = new StringBuilder();
            card = String.valueOf(sb.append(cardNumber).append(cardMark));    // << 숫자와 모양을 랜덤하게 뽑아 card 생성

            if (Arrays.asList(playerDeck).contains(card) || Arrays.asList(computerDeck).contains(card)) {
                return makeComputerCardDeck();
            } else {
                computerDeck[i] = card;                         //  << 랜덤한 카드가 플레이어 덱에 중복이 되면
                                                                //  다시 랜덤카드 뽑고 중복이 안되면 배열에 추가
            }
        }
        return computerDeck;
    }

    public List<String[]> pokerCardsDeal() {
        pokerDeck = new ArrayList<>();
        makePlayerCardDeck();
        makeComputerCardDeck();
        pokerDeck.add(playerDeck);
        pokerDeck.add(computerDeck);

        return pokerDeck;
    }
}
