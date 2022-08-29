package dice.test.reviewExample.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Character {
    private int hp;
    private int power;
    private CharacterManager characterManager;

    public Character(int hp, int power) {
        this.hp = hp;
        this.power = power;
    }

}
