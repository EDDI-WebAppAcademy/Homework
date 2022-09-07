package lbk.homework.day0903.makeGameAlone.entity.player;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Inventory {

    private List itemList;

    Inventory() {
        itemList = new ArrayList();
    }
}
