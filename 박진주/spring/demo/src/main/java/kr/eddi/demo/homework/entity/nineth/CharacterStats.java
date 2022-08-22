package kr.eddi.demo.homework.entity.nineth;

public enum CharacterStats { // 공격력+ 방어력 = 합계 20으로 구성  -> 고민이네 대전방식이 ... 캐릭터- 몬스터 한번 때리기
    궁수(23, 7),
    기사(21, 9),
    마법사(25, 5),
    사냥꾼(18, 12),
    성직자(17, 13),
    요정(19,11),
    힐러(15, 15);


    private final int ATTACK_POWER;
    private final int DEFENSE_POWER;

    private CharacterStats(int ATTACK_POWER, int DEFENSE_POWER){
        this.ATTACK_POWER = ATTACK_POWER;
        this.DEFENSE_POWER = DEFENSE_POWER;
    }
}
