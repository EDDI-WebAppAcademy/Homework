package lbk.homework.day0811.pokerGame2.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Card {

    private CardShape cardShape;
    private CardNumber cardNumber;

    public Card(CardShape cardShape, CardNumber cardNumber) {
        this.cardShape = cardShape;
        this.cardNumber = cardNumber;
    }

}
