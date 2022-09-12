package lbk.homework.day0903.makeGameAlone.entity.player;

import lbk.homework.day0903.makeGameAlone.entity.item.Item;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

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
