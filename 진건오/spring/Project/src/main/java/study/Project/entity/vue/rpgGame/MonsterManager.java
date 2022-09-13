package study.Project.entity.vue.rpgGame;

import lombok.Getter;

@Getter
public class MonsterManager {
    private String name;
    private Integer hp;

    public MonsterManager(String name, Integer hp) {
        this.name = name;
        this.hp = hp;
    }
}
