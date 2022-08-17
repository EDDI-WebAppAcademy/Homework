package lbk.homework.day0811.pokerGame2.entity;

import lombok.Getter;

import java.util.Collections;
import java.util.HashMap;

import static lbk.homework.day0811.pokerGame2.utility.UserInput.getSelectedNumber;
import static lbk.homework.day0811.pokerGame2.utility.UserInput.inputIntKeyBoard;

@Getter
public class Player {

    private String name = "Player";
    private Hand hand;

    public Player(int idx) {
        this.name = name + (idx + 1);
        hand = new Hand();
    }



    public void selectCard() {
        System.out.print("오픈할 카드 인덱스 선택 : ");
        inputIntKeyBoard();

        getHand().getTheRevealedHand().add(
                // 내 패에서 카드를 선택해서 공개할 카드 리스트에 저장.
                (Card) getHand().getAllMyHand().get(getSelectedNumber())
        );

        System.out.println("오픈한 카드 리스트 : " + getHand().getTheRevealedHand().toString());
    }

    public void checkSameCardsShape() {
        HashMap<CardShape, Integer> checkCardShape = new HashMap<>();
        int size = getHand().getAllMyHand().size();
        int cnt = 1;

        for (int i = 0; i < size; i++) {
            Card hasCard = (Card) getHand().getAllMyHand().get(i);
            CardShape cs = hasCard.getCardShape();

            if (checkCardShape.containsKey(cs)) {
                checkCardShape.put(cs, cnt + 1);
            } else {
                checkCardShape.put(cs, cnt);
            }
        }
        System.out.println(getName() + "카드 현황 : " + checkCardShape.toString());
    }
    public void checkSameCardsNumber() {
        HashMap<CardNumber, Integer> checkSameNumber = new HashMap<>();
        int size = getHand().getAllMyHand().size();
        int cnt = 1;

        for (int i = 0; i < size; i++) {
            Card hasCard = (Card) getHand().getAllMyHand().get(i);
            CardNumber cn = hasCard.getCardNumber();

            if (checkSameNumber.containsKey(cn)) {
                checkSameNumber.put(cn, cnt + 1);
            } else {
                checkSameNumber.put(cn, cnt);
            }
        }

        int maxValue = Collections.max(checkSameNumber.values());
        

        System.out.println(getName() + "카드 현황 : " + checkSameNumber.toString());
    }
}
