package lbk.homework.day0903.makeGameAlone.entity.player;

import lbk.homework.day0903.makeGameAlone.entity.item.Item;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class Equipment {

    private List<Item> equipList;



    Equipment() {
        equipList = new ArrayList();
    }
}
