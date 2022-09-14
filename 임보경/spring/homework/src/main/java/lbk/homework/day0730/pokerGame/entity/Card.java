package lbk.homework.day0730.pokerGame.entity;

import lombok.Getter;

import java.util.*;

@Getter
public class Card {
    private List<String> cardPack;
    private final String[] cardShape = {"HEART", "DIA", "CLOVER", "SPADE"};
    private final String[] cardNumber = {"ACE", "2", "3", "4", "5", "6", "7", "8", "9", "10", "JACK", "QUEEN", "KING"};

    public Card() {
        this.cardPack = shuffleCard();
    }

    public List shuffleCard() {
        cardPack = new LinkedList<>();

        Collections.shuffle(Arrays.asList(cardShape));
        Collections.shuffle(Arrays.asList(cardNumber));

        for (int i = 0; i < cardShape.length; i++) {
            for (int j = 0; j < cardNumber.length; j++) {
                cardPack.add(cardShape[i] + ":" + cardNumber[j]);
            }
        }

        Collections.shuffle(cardPack);
        return cardPack;
    }


}
