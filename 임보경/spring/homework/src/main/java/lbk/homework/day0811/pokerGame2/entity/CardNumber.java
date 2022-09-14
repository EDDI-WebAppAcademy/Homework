package lbk.homework.day0811.pokerGame2.entity;

public enum CardNumber {
    KING("KING", 13),
    QUEEN("QUEEN", 12),
    JACK("JACK", 11),
    TEN("10", 10),
    NINE("9", 9),
    EIGHT("8", 8),
    SEVEN("7", 7),
    SIX("6", 6),
    FIVE("5", 5),
    FOUR("4", 4),
    THREE("3", 3),
    TWO("2", 2),
    ACE("ACE", 1);

    private final String name;
    private final int value;

    private CardNumber(String name, int value) {
        this.name = name;
        this.value = value;
    }


}