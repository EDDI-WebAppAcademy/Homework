package lbk.homework.day0903.makeGameAlone.entity.player;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {

    private int level = 1;
    private Integer hp = 50;
    private Integer mp = 30;
    private int defaultAtk = 10;
    private int atkAdded = 0;
    private Integer atk = defaultAtk + atkAdded;
    private Integer money = 0;
    private Integer currentExpBar = 0;
    private Integer totalExpBar = 0;

    private int str = 10;
    private int intelligence = 10;
    private int dex = 10;
    private int def = 10;
    private int vit = 10;

    private Inventory inventory;
    private Equipment equipment;

    public Player(){
        inventory = new Inventory();
        equipment = new Equipment();


    }

}
