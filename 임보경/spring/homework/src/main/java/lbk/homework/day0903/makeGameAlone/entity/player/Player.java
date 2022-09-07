package lbk.homework.day0903.makeGameAlone.entity.player;

import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
public class Player {


    private Status characterStatus;
    private Inventory inventory;
    private Equipment equipment;

    public Player(){
        characterStatus = new Status();
        inventory = new Inventory();
        equipment = new Equipment();
    }

}
