package study.Project.entity.vue.rpgGame;

import lombok.Getter;

@Getter
public enum CharacterJob {

    BASIC("모험가"),
    WARRIOR("전사"),
    WIZARD("마법사"),
    ARCHER("궁수"),
    THIEF("도적");

    private final String CHARACTER_JOB_NAME;

    CharacterJob(String CHARACTER_JOB_NAME) {
        this.CHARACTER_JOB_NAME = CHARACTER_JOB_NAME;
    }
}
