package kr.eddi.demo.entity.vue.thirthyoneth;

import lombok.Getter;

@Getter
public class CharacterManager {

    private Character character;

    public void makeCharacter(String name, String job) {
        character = new Character(name);
        character.setJob(job);
    }
}
