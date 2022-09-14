package kr.eddi.demo.entity.ten;

import lombok.Getter;

@Getter
public enum PokerCardPattern {

    HIGH_CARD("하이카드", 1),
    ONE_PAIR("원페어", 2),
    TWO_PAIR("투페어", 3),
    TRIPPLE("트리플", 4),
    STRAIGHT("스트레이트", 5),
    FLUSH("플러쉬", 6),
    FULL_HOUSE("풀 하우스", 7),
    STRAIGHT_FLUSH("스트레이트 플러쉬", 8),
    ROYAL_FLUSH("로얄 플러쉬", 9);
    private final String name;
    private final int value;

    private PokerCardPattern(String name, int value) {
        this.name = name;
        this.value = value;
    }
}
