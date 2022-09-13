package kr.eddi.demo.entity.vue.thirthyoneth;

import lombok.Getter;

@Getter
public enum KnightStatus {

    /* 직업에 따라 기본 수치가 달라질 수 있으므로 만약 직업 변경기능을 추가할 시 그에 따른 enum 을 새로 생성하고 앞에 직업 이름을 붙일 것 */

    KNIGHT_HP("Knight HP", 50),
    KNIGHT_MP("Knight MP", 30),
    KNIGHT_ATK("Knight Atk", 10),
    KNIGHT_DEF("Knight Def", 10),
    KNIGHT_STR("Knight Str", 10),
    KNIGHT_INTELLIGENCE("Knight Intelligence", 10),
    KNIGHT_DEX("Knight Dex", 10),
    KNIGHT_VIT("Knight VIT", 10),
    KNIGHT_MEN("Knight MEN", 10);
    private final String name;
    private final int value;

    private KnightStatus(String name, int value) {
        this.name = name;
        this.value = value;
    }
}
