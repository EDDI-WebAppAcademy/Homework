package kr.eddi.demo.entity.basic.Poker;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Setter
@Getter
public class Player {

    final int SEVEN_POKER = 7;
    final int FIVE_CARD = 5;

    private String name;
    private int money;
    ArrayList<PlayingCards> Hands = new ArrayList<>();

    //PlayingCards[] Hands = new PlayingCards[SEVEN_POKER];

}
