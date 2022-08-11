package com.example.demo.entity.basic.poker;

import com.example.demo.utillity.basic.poker.UserInput;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@ToString
public class Player {
    private List<Map<PokerCardShape, PokerCardCharacter>> cardsDeck;

    public Player() {
        cardsDeck = new ArrayList<>();
    }

    /**
     * <문양, 숫자>형태의 카드 덱 Map을 <br>
     * cardsDeck 리스트에 저장하는 메서드
     * @param newCardDeck
     */
    public void acquireNewCards(Map<PokerCardShape, PokerCardCharacter> newCardDeck) {
        //System.out.println("newCardDeck: " + newCardDeck);

        cardsDeck.add(newCardDeck);
    }


    /**
     *플레이어가 공개할 카드를 선택하는 메서드
     * @return 선택한 카드
     */
    public Map<PokerCardShape, PokerCardCharacter> publishingPlayersCard() {
        System.out.println("현재 손패입니다");
        System.out.println(cardsDeck);
        System.out.print("공개할 카드를 선택하세요: ");

        UserInput.inputIntKeyBoard();
        return cardsDeck.get(UserInput.getSelectedNumber());
    }
}

