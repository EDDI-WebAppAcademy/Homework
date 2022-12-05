package lbk.homework.day0917.makeGame.entity;

import lombok.Getter;

@Getter
public enum CharacterJob {

    BEGINNER ("모험가"),
    SWORD_MAN ("검사"),
    MAGICIAN ("폭렬마법사"),
    KNIGHT ("기사");

    private final String JOB_NAME;

    CharacterJob(String JOB_NAME) {
        this.JOB_NAME = JOB_NAME;
    }
}
