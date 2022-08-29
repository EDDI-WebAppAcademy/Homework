package choijaemin.homework.entity.nineth;

import lombok.Getter;

@Getter
public class Card {
    private int[] hart;
    private int[] spade;
    private int[] colver;
    private int[] diamond;
    private final int BAIS = 1;
    private final int MAX_CARD_NUM = 13;

    public Card() {
        this.hart = new int[MAX_CARD_NUM];
        this.spade = new int[MAX_CARD_NUM];
        this.colver = new int[MAX_CARD_NUM];
        this.diamond = new int[MAX_CARD_NUM];

        for (int i = 1; i < MAX_CARD_NUM + BAIS; i++) {
            this.hart[i - BAIS] = i;
            this.spade[i - BAIS] = i;
            this.colver[i - BAIS] = i;
            this.diamond[i - BAIS] = i;
        }
    }
}