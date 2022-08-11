package lbk.homework.day0811.pokerGame2.entity;

import lombok.Getter;

@Getter
public class Player {

    private String name = "Player";
    private Hand hand;

    public Player(int idx) {
        this.name = name + (" " + idx + 1);
        hand = new Hand();
    }



}
