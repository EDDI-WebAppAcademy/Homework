package kr.eddi.demo.entity.basic.twelfth;

import kr.eddi.demo.utility.basic.twelfth.UserInput;
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

    public void acquireNewCards(Map<PokerCardShape, PokerCardCharacter> newCardDeck) { // 플레이어 카드덱에 카드가 1장씩 추가되는 기능
        // System.out.println("newCardDeck: " + newCardDeck);
        cardsDeck.add(newCardDeck);
    }

    public Map<PokerCardShape, PokerCardCharacter> publishingPlayersCard() {
        System.out.println("현재 손패입니다.");
        System.out.println(cardsDeck);
        System.out.print("공개할 카드를 선택하세요: ");

        UserInput.inputIntKeyBoard();
        return cardsDeck.get(UserInput.getSelectedNumber());
    }

}
