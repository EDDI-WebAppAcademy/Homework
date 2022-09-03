package lbk.homework.day0903.makeGameAlone.entity.monster;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Monsters {

    private List<Object> monsterBook;
    private Goblin goblin;
    private Knoll knoll;
    private Skeleton skeleton;

    public Monsters() {
        this.goblin = new Goblin();
        this.knoll = new Knoll();
        this.skeleton = new Skeleton();
        registrationMonsters();
    }

    public void registrationMonsters() {
        monsterBook = new ArrayList<>();
        monsterBook.add(goblin);
        monsterBook.add(knoll);
        monsterBook.add(skeleton);
    }

}
