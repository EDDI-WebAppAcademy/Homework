package com.example.demo.entity.basic.poker;


import lombok.ToString;

import java.util.*;

@ToString
public class PokerCard {
    // 1. 카드 문양(CardShape): 스페이드, 다이아, 하트, 클로버
    // 2. 카드 문자(CardCharacter): K, Q, J, 10, 9, 8, 7, 6, 5, 4, 3, 2, ACE
    private Map<Integer, Map<PokerCardShape, PokerCardCharacter>> cards;
    private Map<PokerCardShape, PokerCardCharacter> cardValues;
    private int currentCardIdx;

    /**
     * [포커카드 생성자]
     * <숫자, <문양, 숫자>>형태의 Map(cards)에 카드 52개 저장
     */
    public PokerCard() {
        int cnt = 0;
        currentCardIdx = 0;

        cards = new LinkedHashMap<>();

        // 한 개 뽑힌 결과 <- 뽑을 리스트들
        // foreach(한 개 뽑힌 결과: 뽑을 리스트들) 형태로 사용함
        // >>> 이중 해쉬로 변경 필요 <<<
        // key: 0, value: <Shape, Character> <<<---
        // 안 된다고 우왕좌왕하면서 이것 저것 시도해보는 것 보다
        // 안되는 원인을 파악하고 이에 대한 해결 전략을 구성하는것이 중요합니다.

        for (PokerCardShape pokerCardShape : PokerCardShape.values()) {
            for (PokerCardCharacter pokerCardCharacter : PokerCardCharacter.values()) {
                cardValues = new LinkedHashMap<>();
                cardValues.put(pokerCardShape, pokerCardCharacter);

                cards.put(cnt++, cardValues);
            }
        }

        System.out.println("Card: " + cards);
    }

    /**
     * cards에 담겨져있는 카드를 섞어주는 메서드
     * 섞인 카드 순서를 유지하기위해 linkedHashMap 사용
     */
    public void shuffle() {
        List keys = new ArrayList(cards.keySet());
        Collections.shuffle(keys);

        // ... 바보짓 했음 -> LinkedHashMap() 이것을 써야 순서가 보장됨
        Map<Integer, Map<PokerCardShape, PokerCardCharacter>> cardsBackup = new LinkedHashMap<>();

        for (Object object: keys) {
            cardsBackup.put((Integer)object, cards.get(object));
        }

        cards = cardsBackup;
    }

    // 현재 문제: List는 계속 정렬을 수행하고 있음.
    //          LinkedHashMap에 의해 순서가 보장된 정보가 List에 의해 다시 재정렬 되어 문제가 발생함.

    /**
     * 카드를 나눠주는 메서드 <br>
     * 플레이어에게 나눠준 카드는 cards에서 삭제해준다.
     * @return 나눠준 카드
     */
    public Map<PokerCardShape, PokerCardCharacter> divideCard() {
        Map<PokerCardShape, PokerCardCharacter> dividedPlayerDeck;

        Map.Entry<Integer, Map<PokerCardShape, PokerCardCharacter>> entry = cards.entrySet().iterator().next();
        dividedPlayerDeck = entry.getValue();

        //System.out.println("dividedPlayerDeck: " + dividedPlayerDeck);

        Integer key = entry.getKey();
        System.out.println("key: " + key);
        cards.remove(key);

        return dividedPlayerDeck;
    }
}

