package com.example.homework.pokergames.try2.entity;

import com.example.homework.utility.CustomRandom;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter

public class Trump {
    private List<String> cardDeck;
    private final int CARDS_LENGTH = 52;
    private final int SUIT_MIN = 1;
    private final int SUIT_MAX = 4;

    private final int CARD_NUM_MIN = 1;
    private final int CARD_NUM_MAX = 13;


    private final int SPADE_NUM = 1;
    private final int HEART_NUM = 2;
    private final int DIAMOND_NUM = 3;
    private final int CLUB_NUM = 4;

    private final int ACE_NUM = 1;
    private final int JACK_NUM = 11;
    private final int QUEEN_NUM = 12;
    private final int KING_NUM = 13;


    public Trump() {
        cardDeck = new ArrayList<>(CARDS_LENGTH);
    }

    public void shuffle() {
        for (int curCardIdx = 0; curCardIdx < CARDS_LENGTH; curCardIdx++) {
            String card = "";
            if (curCardIdx == 0) {
                card = makeRandomCard();
                cardDeck.add(card);
            } else {
                do{
                    card = makeRandomCard();
                } while(verifyDuplicateCard(card, cardDeck));
                cardDeck.add(card);
            }
        }
    }

    private boolean verifyDuplicateCard(String card, List<String> cardDeck) {
        String compareTargetCard = card;
        for (int i = 0; i < cardDeck.size(); i++) {
            String eachCard = cardDeck.get(i);
            if (compareTargetCard.equals(eachCard)) {
                return true;
            }
        }
        return false;
    }

    private String makeRandomCard() {
        String card = "";
        int suit = 0;
        int num = 0;

        suit = CustomRandom.makeIntCustomRandom(SUIT_MIN, SUIT_MAX);
        card += choiceSuit(suit);

        num = CustomRandom.makeIntCustomRandom(CARD_NUM_MIN, CARD_NUM_MAX);
        card += choiceCardNum(num);

        return card;
    }


    private String choiceCardNum(int choiceNum) {
        String tempNum = "";
        if (choiceNum > 1 && choiceNum < 11) {
            tempNum = "" + choiceNum;
        } else {
            switch (choiceNum) {
                case ACE_NUM:
                    tempNum = "ACE";
                    break;

                case JACK_NUM:
                    tempNum = "JACK";
                    break;

                case QUEEN_NUM:
                    tempNum = "QUEEN";
                    break;

                case KING_NUM:
                    tempNum = "KING";
                    break;
            }
        }
        return tempNum;
    }

    private String choiceSuit(int suitNum) {
        String tempSuit = "";
        switch (suitNum) {
            case SPADE_NUM:
                tempSuit = "SPADE-";
                break;

            case HEART_NUM:
                tempSuit = "HEART-";
                break;

            case DIAMOND_NUM:
                tempSuit = "DIAMOND-";
                break;

            case CLUB_NUM:
                tempSuit = "CLUB-";
                break;
        }
        return tempSuit;
    }
}
