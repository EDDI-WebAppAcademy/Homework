package lbk.homework.day0730.pokerGame.entity;

import lbk.homework.day0730.pokerGame.utility.UserInput;
import lombok.Getter;

import static lbk.homework.day0730.pokerGame.utility.UserInput.getSelectedNumber;

@Getter
public class PokerGamer{

    private String name = "PokerPlayer";
    private Hand hand;

    public PokerGamer(int idx) {
        this.name = name + (idx + 1);
        hand = new Hand();
    }

    public void selectCard() {
        System.out.print("오픈할 카드를 선택하세요 : ");
        UserInput.inputIntKeyBoard();

        String tmpCard = getHand().getCardOnHand().get(getSelectedNumber());
        getHand().getOpenCards().add(tmpCard);

        System.out.println("현재 오픈한 카드들 : " + getHand().getOpenCards());
    }


}
