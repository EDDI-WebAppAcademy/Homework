package kr.eddi.demo2.entity.vue.rpg;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ExperienceManager {
    private String name;

    public ExperienceManager(String name) {
        this.name = name;
    }
}
