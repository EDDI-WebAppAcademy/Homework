package lbk.homework.day0812.javaPrcatice;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameCharacter {

    private Food food;
    private int hp = 130;
    private int max_hp = 200;
    private int mp = 50;
    private int max_mp = 80;

    public GameCharacter() {
        food = new Food();


    }
}
