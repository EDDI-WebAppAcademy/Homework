package lbk.homework.day0730.pokerGame.entity;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Hand {

    private List<String> cardOnHand;
    private List<String> openCards;

    public Hand() {
        cardOnHand = new ArrayList<>();
        openCards = new ArrayList<>();
    }
}
