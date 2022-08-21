package lbk.homework.day0730.pokerGame.utility;

import java.util.*;

public class Card {
    private static List<String> cardPack;

    private static final String[] cardShape = {"HEART", "DIA", "CLOVER", "SPADE"};
    private static final String[] cardNumber = {"ACE","2","3","4","5","6","7","8","9","10","JACK", "QUEEN", "KING"};



    public static void shuffleCard() {
        cardPack = new LinkedList<>();

        Collections.shuffle(Arrays.asList(cardShape));
        Collections.shuffle(Arrays.asList(cardNumber));

        for (int i = 0; i < cardShape.length; i++) {
            for (int j = 0; j < cardNumber.length; i++){
                cardPack.add(cardShape[i]+" "+cardNumber[j]);
            }
        }

        Collections.shuffle(cardPack);
    }


}
