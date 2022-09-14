package kr.eddi.demo.entity.basic.twelveth;

import kr.eddi.demo.utility.basic.twelveth.UserInput;
import lombok.ToString;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@ToString
public class Player {
    private List<Map<PokerCardShape, PokerCardCharacter>> cardsDeck;

    public Player() {

        cardsDeck = new ArrayList<>();
    }

    public void acquireNewCards(Map<PokerCardShape, PokerCardCharacter> newCardDeck) {
        System.out.println("newCardDeck: " + newCardDeck);

        cardsDeck.add(newCardDeck);
    }

    public Map<PokerCardShape, PokerCardCharacter> publishingPlayersCard() {
        System.out.println("현재 손패입니다");
        System.out.println(cardsDeck);
        System.out.print("공개할 카드를 선택하세요: ");

        UserInput.inputIntKeyBoard();
        return cardsDeck.get(UserInput.getSelectedNumber());
    }
}