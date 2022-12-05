package kr.eddi.demo.entity.basic.practiceQuestion;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {
    private int CharacterMAXHp = 100;
    private int CharacterMinHp = 0;
    private int CharacterCurrentHp = 10;

    private int CharacterMAXMP = 30;
    private int CharacterMinMP = 0;
    private int CharacterCurrentMP = 3;

    private int CharacterAttack = 10;
    private int CharacterDefensive = 10;
}
