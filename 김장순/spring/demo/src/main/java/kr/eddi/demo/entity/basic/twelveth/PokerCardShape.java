package kr.eddi.demo.entity.basic.twelveth;

public enum PokerCardShape {
    SPADE("스페이드",1),
    DIAMOND("다이아",2),
    HEART("하트",3),
    CLOVER("클로버",4)
    ;

    private final String name;
    private final int value;

    PokerCardShape(String name, int value) {
        this.name = name;
        this.value = value;
    }
}
