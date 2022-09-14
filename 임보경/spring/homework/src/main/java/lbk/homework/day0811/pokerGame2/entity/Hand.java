package lbk.homework.day0811.pokerGame2.entity;

import lombok.Getter;

import java.util.LinkedList;
import java.util.List;


@Getter
public class Hand {

    private List allMyHand;
    private List<Card> theRevealedHand;

    public Hand() {
        allMyHand = new LinkedList();
        theRevealedHand = new LinkedList();
    }
}
