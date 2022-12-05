package lbk.homework.day0917.makeGame.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Character {

    private CharacterStatus characterStatus;

    public Character() {
        characterStatus = new CharacterStatus(CharacterJob.BEGINNER);
    }
}
