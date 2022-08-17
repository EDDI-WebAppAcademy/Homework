package lbk.homework.day0811.pokerGame2.utility;

import lbk.homework.day0811.pokerGame2.entity.Card;
import lbk.homework.day0811.pokerGame2.entity.CardNumber;
import lbk.homework.day0811.pokerGame2.entity.CardShape;
import lombok.Getter;
import lombok.ToString;

import java.util.*;

@Getter
@ToString
public class SettingCards {
    private List<Card> cards;
    private final int NUM_OF_CARDS = 52;

    public SettingCards() {
        cards = new LinkedList<>();

        for (CardShape cardShape : CardShape.values()) {
            for (CardNumber cardNumber : CardNumber.values()) {
               cards.add(new Card(cardShape, cardNumber));
            }
        }

        Collections.shuffle(cards);
    }

}
