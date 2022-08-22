package kr.eddi.demo.homework.entity.nineth;

public enum MonsterStats { // 공격력+ 방어력 = 합계 30으로 구성

    피카츄(20, 10),
    파이리(25, 5),
    꼬북이(15, 15),
    이상해씨(18, 12),
    냐옹이(10, 20),
    고라파덕(5, 25),
    잠만보(0, 30);


    private final int ATTACK_POWER;
    private final int DEFENSE_POWER;

    private MonsterStats(int ATTACK_POWER, int DEFENSE_POWER){
        this.ATTACK_POWER = ATTACK_POWER;
        this.DEFENSE_POWER = DEFENSE_POWER;
    }

}
