package lbk.homework.day0903.makeGameAlone.controller.request;

import lbk.homework.day0903.makeGameAlone.entity.item.Item;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;

@Getter
@ToString
public class RequestData {

    /** 구매한 아이템 데이터 */
    ArrayList<Item> shoppingCart;

    /** 인벤토리 > 장비 , 장비 > 인벤토리 */
    ArrayList<Item> receiveEquipItem;
    ArrayList<Item> receiveRemoveEquipItem;
}
