package kr.eddi.demo.entity.basic.twelfth;

import lombok.ToString;

import java.util.*;

@ToString
public class PokerCard {
    // 1. 카드 문양(CardShape): 스페이드, 다이아, 하트, 클로버
    // 2. 카드 문자(CardCharacter): K, Q, J, 10, 9, 8 ,7, 6, 5, 4, 3, 2, A

    // private Map<PokerCardShape, PokerCardCharacter> cards;
    private Map<Integer, Map<PokerCardShape, PokerCardCharacter>> cards;
    private Map<PokerCardShape, PokerCardCharacter> cardValues;
    private int currentCardIdx;

    public PokerCard() {
        int cnt = 0;

        cards = new LinkedHashMap<>();

        // 한 개 뽑힌 결과 <- 뽑을 리스트들
        // foreach(한 개 뽑힌 결과 : 뽑을 리스트들) 형태로 사용함
        // >>> 이중 해쉬로 변경 필요 <<<
        // key: 0, value <Shape, Character> <<<---
        // 안된다고 이것 저것 시도해보는 것보다
        // 안되는 원인을 파악하고 이에 대한 해결 전략을 구성하는 것이 중요하다.

        for (PokerCardShape pokerCardShape: PokerCardShape.values()) { // 52장의 카드 생성
            for (PokerCardCharacter pokerCardCharacter : PokerCardCharacter.values()) {
                cardValues = new LinkedHashMap<>();
                cardValues.put(pokerCardShape, pokerCardCharacter); // cardValues에 문양과 문자를 넣고
                cards.put(cnt++, cardValues); // cards의 value값에 cardsValues를 넣어줌 ---> (0 : (spade : K)), (1 : (spade : Q)) 이렇게 나옴.
            }
        }
    }

    public void shuffle() {
        List keys = new ArrayList(cards.keySet()); // <>데이터 타입을 지정하지 않아도 적합한 타입을 감지하여 처리함
        Collections.shuffle(keys);

        // LinkedHashMap<>()을 사용해야 shuffle 후 순서가 보장됨.
        Map<Integer, Map<PokerCardShape, PokerCardCharacter>> cardsBackup = new LinkedHashMap<>();

        for (Object object : keys) {
            cardsBackup.put((Integer)object, cards.get(object));
        }

        cards = cardsBackup;
    }

    // 현재 문제: List는 계속 정렬을 수행하고 있음.
    //          LinkedHashMap에 의해 순서가 보장된 정보가 List에 의해 다시 재정렬되어 문제가 발생함.
    public Map<PokerCardShape, PokerCardCharacter> divideCard() {
        Map<PokerCardShape, PokerCardCharacter> dividedPlayerDeck;

        Map.Entry<Integer, Map<PokerCardShape, PokerCardCharacter>> entry = cards.entrySet().iterator().next();
        dividedPlayerDeck = entry.getValue();

        // System.out.println("dividedPlayerDeck: " + dividedPlayerDeck);

        Integer key = entry.getKey();
        // System.out.println("key: " + key);
        cards.remove(key); // 뽑은 카드가 다시 뽑히지 않게 삭제

        return dividedPlayerDeck;


    }
}
