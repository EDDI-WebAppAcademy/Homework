package lbk.homework.day0903.makeGameAlone.entity.player;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {

    private int level = 1;
    private int hp = 50;
    private int mp = 30;
    private int defaultAtk = 0;
    private int atkAdded = 0;
    private int atk = defaultAtk + atkAdded;
    private int money = 0;
    private int currentExpBar = 0;
    private int totalExpBar = 0;
}
