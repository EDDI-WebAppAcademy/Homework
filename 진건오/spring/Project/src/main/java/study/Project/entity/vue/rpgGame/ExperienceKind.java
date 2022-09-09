package study.Project.entity.vue.rpgGame;

import lombok.Getter;

@Getter
public enum ExperienceKind {
    CHANGE_HP("hp",50),
    CHANGE_MP("mp",50),
    CHANGE_ATK("atk",5),
    CHANGE_STR("str",5),
    CHANGE_DEX("dex",5),
    CHANGE_INT("int",5),
    CHANGE_DEF("def",5);

    private String CHANGE_EXPERIENCE_KIND_NAME;
    private Integer CHANGE_CHARACTER_EXPERIENCE_VALUE;



    ExperienceKind(String CHANGE_EXPERIENCE_KIND_NAME, Integer CHANGE_CHARACTER_EXPERIENCE_VALUE) {
        this.CHANGE_EXPERIENCE_KIND_NAME = CHANGE_EXPERIENCE_KIND_NAME;
        this.CHANGE_CHARACTER_EXPERIENCE_VALUE = CHANGE_CHARACTER_EXPERIENCE_VALUE;
    }
}
