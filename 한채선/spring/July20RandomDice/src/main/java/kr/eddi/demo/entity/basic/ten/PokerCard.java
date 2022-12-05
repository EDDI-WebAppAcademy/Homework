package kr.eddi.demo.entity.basic.ten;

import lombok.Getter;

import java.util.*;


@Getter
public class PokerCard {
  /*  private final int ACE_SET = 1;
    private final int JACK = 11;
    private final int QUEEN = 12;
    private final int KING = 13;
    private final int ACE_VALUE = 14;

    private String[] spades;
    private String[] hearts;
    private String[] clovers;
    private String[] diamonds;

    private Set<String> totalDeck;*/

    private Map<Integer, Map<CardShape, CardCharacter>> cards;
    private Map<CardShape, CardCharacter> cardValues;
    private int currentCardIndex;

/*
    public PokerCard() {
        prepareCardDeck();
    }
*/

    public PokerCard() {
        int cnt = 0;
        currentCardIndex = 0;
        cards = new HashMap<>();

        for (CardShape cardShape : CardShape.values()) {
            for (CardCharacter cardCharacter : CardCharacter.values()) {
                cardValues = new HashMap<>();
                cardValues.put(cardShape, cardCharacter);
                cards.put(cnt++, cardValues);
            }
        }
    }

/*

    public void prepareCardDeck(){
        setCards(spades, "Spade_");
        setCards(hearts, "Heart_");
        setCards(clovers, "Clover_");
        setCards(diamonds, "Diamond_");
    }

    public void shuffleWholeDeck() {
        setWholeDeck(spades);
        setWholeDeck(hearts);
        setWholeDeck(clovers);
        setWholeDeck(diamonds);
    }

    public void setCards(String[] cardName, String Shape) {
        cardName = new String[13];
        for (int i = 1; i < 14; i++) {
            switch(i) {
                case ACE_SET ->  cardName[ACE_SET-1] = Shape + "ACE";
                case JACK -> cardName[JACK - 1] = Shape + "JACK";
                case QUEEN -> cardName[QUEEN - 1] = Shape + "QUEEN";
                case KING -> cardName[KING - 1] = Shape + "KING";
                default -> cardName[i-1] = Shape + i;
            }
        }
    }

    public void setWholeDeck(String[] cardName) {
        totalDeck = new HashSet<>();
        for (int i = 0; i < cardName.length ; i++) {
            totalDeck.add(cardName[i]);
        }
    }
*/


  /*  public void shuffle() {
        List keys = new ArrayList(cards.keySet());
        Collections.shuffle(keys);

        Map<Integer, Map<CardShape, CardCharacter>> cardBackUp = new LinkedHashMap<>();

        for(Object object : keys) {
            System.out.println("after Shuffle Card: " + cards.get(object));
        }

        cards = cardBackUp;
    }

    public List <Map<CardShape, CardCharacter>> divideCards(int currentRound) {
        List<Map<CardShape, CardCharacter>> tmpDeck = new ArrayList<>();

        if (currentRound == 0) {
            for (int i = 0; i < 3; i++) {
                tmpDeck.add(cards.get(i));
                currentCardIndex++;
            }
        } else {
            tmpDeck.add(cards.get(currentCardIndex++));
        }
        return tmpDeck;
    }*/
}
