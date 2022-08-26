package lbk.homework.day0730.pokerGame.entity;

public class PokerGamer implements Player {

    private String name;
    private Hand hand;

    public PokerGamer() {
        hand = new Hand();
    }
}
