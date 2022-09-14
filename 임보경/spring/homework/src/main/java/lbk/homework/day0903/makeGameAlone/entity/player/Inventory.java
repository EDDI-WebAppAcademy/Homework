package lbk.homework.day0903.makeGameAlone.entity.player;

import lbk.homework.day0903.makeGameAlone.entity.item.Item;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Inventory {

    private List<Item> inven;


    Inventory() {
        inven = new ArrayList();
    }


}
